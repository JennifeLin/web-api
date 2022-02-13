package com.alg.boot.webapi.apps.cms.posts

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "tags", path = "tags")
interface TagRepository: JpaRepository<Tag, Long>
