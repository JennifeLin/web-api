package com.alg.boot.webapi.apps.cms.sites

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SiteRepository: JpaRepository<Site, Long> {
    fun findByDomain(domain: String): Optional<Site>
}
