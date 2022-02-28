package com.alg.boot.webapi.apps.security.users.service

import com.alg.boot.webapi.apps.security.users.dto.UserLoginRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class UserData(private val authenticationManager: AuthenticationManager) : UserService {
    override fun authenticate(login: UserLoginRequest) : String {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(login.username, login.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        return authentication.name
    }
}
