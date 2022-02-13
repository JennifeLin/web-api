package com.alg.boot.webapi.apps.cms.posts

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
interface CategoryRepository: JpaRepository<Category, Long>
