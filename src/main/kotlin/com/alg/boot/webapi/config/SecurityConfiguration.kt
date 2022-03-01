package com.alg.boot.webapi.config

import com.alg.boot.webapi.apps.security.jwt.AuthenticationEntryPointJWT
import com.alg.boot.webapi.apps.security.jwt.AuthenticationFilterJWT
import com.alg.boot.webapi.apps.security.jwt.TokenProviderJWT
import com.alg.boot.webapi.apps.security.users.service.CustomUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfiguration(
    private val authenticationEntryPointJWT: AuthenticationEntryPointJWT,
    private val customUserDetailsService: CustomUserDetailsService,
    private val corsConfiguration: CorsConfiguration,
    private val tokenProviderJWT: TokenProviderJWT
    ) : WebSecurityConfigurerAdapter() {

    @Bean
    fun authenticationFilterJWT(): AuthenticationFilterJWT {
        return AuthenticationFilterJWT(customUserDetailsService, tokenProviderJWT)
    }

    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(http: HttpSecurity?) {
        http!!
            .cors()
            .configurationSource(corsConfiguration.corsConfigurationSource())
            .and()
            .csrf()
            .disable()
            .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPointJWT)
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/swagger-ui.html").permitAll()
            .anyRequest().authenticated()
        http.addFilterBefore(authenticationFilterJWT(), UsernamePasswordAuthenticationFilter::class.java)
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}
