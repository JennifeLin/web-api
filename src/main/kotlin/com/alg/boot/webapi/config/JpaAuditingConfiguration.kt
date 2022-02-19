package com.alg.boot.webapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.auditing.DateTimeProvider
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.time.OffsetDateTime
import java.util.*


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider", dateTimeProviderRef = "auditingDateTimeProvider")
class JpaAuditingConfiguration {
    @Bean(name = ["auditingDateTimeProvider"])
    fun dateTimeProvider(): DateTimeProvider? {
        return DateTimeProvider { Optional.of(OffsetDateTime.now()) }
    }

    @Bean
    fun auditorProvider(): AuditorAware<String> {
        // SecurityContextHolder.getContext().authentication.name
        return AuditorAware { Optional.of("Anonymous") }
    }
}
