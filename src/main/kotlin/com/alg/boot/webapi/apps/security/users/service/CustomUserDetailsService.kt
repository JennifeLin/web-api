package com.alg.boot.webapi.apps.security.users.service

import com.alg.boot.webapi.apps.security.roles.Role
import com.alg.boot.webapi.apps.security.users.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = username?.let { userRepository.findByUsernameAndIsEnabledIsTrue(it).orElseThrow {
            UsernameNotFoundException("No se puede procesar la solicitud con ese nombre de usuario")
        } }
        return User(user!!.username, user.password, mapRoles(user.roles!!))
    }

    fun mapRoles(roles: Set<Role>) : Collection<GrantedAuthority> {
        return roles.stream().map { role ->
            SimpleGrantedAuthority(role.name)
        }.collect(Collectors.toList())
    }
}
