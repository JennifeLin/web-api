package com.alg.boot.webapi.apps.cms.sites

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "sites", path = "sites")
interface SiteRepository: JpaRepository<Site, Long> {
    fun findByDomain(domain: String): Optional<Site>
}
