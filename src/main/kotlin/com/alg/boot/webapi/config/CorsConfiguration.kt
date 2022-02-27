package com.alg.boot.webapi.config

import com.arthurolg.constants.Constants
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfiguration {
    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = org.springframework.web.cors.CorsConfiguration()
        config.allowCredentials = true
        config.allowedOriginPatterns = listOf("http://localhost:3000", "https://*.webapi.com")
        config.allowedHeaders = listOf(Constants.ALL)
        config.allowedMethods = listOf(Constants.ALL)
        source.registerCorsConfiguration("/api${Constants.DEFAULT_ALL_PATH_PATTERN}", config)
        return CorsFilter(source)
    }
}
