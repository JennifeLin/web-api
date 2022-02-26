package com.alg.boot.webapi.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EntityScan("com.alg.boot.webapi.apps")
@EnableJpaRepositories("com.alg.boot.webapi.apps")
@EnableTransactionManagement
class DomainConfig
