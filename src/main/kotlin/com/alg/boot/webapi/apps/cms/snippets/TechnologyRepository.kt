package com.alg.boot.webapi.apps.cms.snippets

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "technologies", path = "technologies")
interface TechnologyRepository: JpaRepository<Technology, Long>
