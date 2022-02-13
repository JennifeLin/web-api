package com.alg.boot.webapi.apps.cms.pages

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "pages", path = "pages")
interface PageRepository: JpaRepository<Page, Long>
