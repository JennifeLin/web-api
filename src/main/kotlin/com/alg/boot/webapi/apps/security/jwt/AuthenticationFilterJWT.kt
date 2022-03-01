package com.alg.boot.webapi.apps.security.jwt

import com.alg.boot.webapi.apps.security.users.service.CustomUserDetailsService
import com.arthurolg.constants.Constants
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilterJWT(
    private val customUserDetailsService: CustomUserDetailsService,
    private val tokenProviderJWT: TokenProviderJWT
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = getTokenFromRequest(request)
        if (StringUtils.hasText(token) && tokenProviderJWT.validateToken(token!!)) {
            val username = tokenProviderJWT.getUsernameFromToken(token)
            val userDetails = customUserDetailsService.loadUserByUsername(username)
            val authenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authenticationToken
        }
        filterChain.doFilter(request, response)
    }

    private fun getTokenFromRequest(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(Constants.TOKEN_HEADER)
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(Constants.TOKEN_PREFIX)) {
            return bearerToken.replace(Constants.TOKEN_PREFIX, "")
        }
        return null
    }
}
