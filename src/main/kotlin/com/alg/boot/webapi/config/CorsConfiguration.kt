package com.alg.boot.webapi.config

import com.arthurolg.constants.Constants
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Component
class CorsConfiguration {

    companion object {
        const val MAX_AGE_SECS: Long = 3_600
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource? {
        val configuration = org.springframework.web.cors.CorsConfiguration()
        configuration.allowedOrigins = listOf(Constants.ALL)
        configuration.allowedMethods = listOf(Constants.ALL)
        configuration.allowedHeaders = listOf(Constants.ALL)
        configuration.maxAge = MAX_AGE_SECS
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration(Constants.DEFAULT_ALL_PATH_PATTERN, configuration)
        return source
    }
}
