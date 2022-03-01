package com.alg.boot.webapi.apps.security.jwt

import com.alg.boot.webapi.handlers.exceptions.ServerErrorException
import com.arthurolg.constants.DateConstants
import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Component
class TokenProviderJWT {
    @Value("\${jwt.secret}")
    var secret: String? = null
    @Value("\${jwt.expiration-ms}")
    var expiration: Int? = null

    fun generateToken(authentication: Authentication): String {
        val zone = ZoneId.of(DateConstants.TIMEZONE)
        val username = authentication.name
        val minimumExpiration = 4_000_000
        var milliseconds = expiration?:minimumExpiration
        if (milliseconds > minimumExpiration) {
            milliseconds = minimumExpiration
        }
        val hours = milliseconds.div(1000).div(60).div(60).toLong()
        val today = LocalDateTime.now(zone)
        val expiration = today.plusHours(hours)
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date.from(today.atZone(zone).toInstant()))
            .setExpiration(Date.from(expiration.atZone(zone).toInstant()))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
    }

    fun getUsernameFromToken(token: String): String {
        val claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
        return claims.subject
    }

    fun validateToken(token: String): Boolean {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
            return true
        } catch (signature: SignatureException) {
            throw ServerErrorException("Token invalido")
        } catch (malformed: MalformedJwtException) {
            throw ServerErrorException("Error en la estructura del Token")
        } catch (expired: ExpiredJwtException) {
            throw ServerErrorException("Token expirado")
        } catch (unsupported: UnsupportedJwtException) {
            throw ServerErrorException("Sin soporte al token")
        } catch (illegal: IllegalArgumentException) {
            throw ServerErrorException("Token vacío")
        }
    }
}
