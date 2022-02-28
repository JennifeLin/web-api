package com.alg.boot.webapi.config

import com.arthurolg.constants.AuthoritiesConstants
import com.arthurolg.enums.Role
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(http: HttpSecurity?) {
        http!!.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/api/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        val adminRole = AuthoritiesConstants.getSimpleName(Role.ROLE_ADMIN.name)
        val admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("password"))
            .roles(adminRole)
            .build()
        val userRole = AuthoritiesConstants.getSimpleName(Role.ROLE_USER.name)
        val user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("password"))
            .roles(userRole)
            .build()
        return InMemoryUserDetailsManager(admin, user)
    }
}
