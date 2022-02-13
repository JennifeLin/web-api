package com.alg.boot.webapi.apps.cms.sites

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "seo-contents", path = "seo-contents")
interface SeoRepository: JpaRepository<Seo, Long>
