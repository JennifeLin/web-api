package com.alg.boot.webapi.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SpringDocConfiguration {
    @Bean
    fun webApiDoc(): OpenAPI? {
        val license: License = License()
            .name("Apache 2.0")
            .url("https://springdoc.org")
        val info: Info = Info()
            .title("Web API")
            .description("Backend para los proyectos profesionales")
            .version("v1.0.0")
            .license(license)
        return OpenAPI()
            .info(info)
    }
}
