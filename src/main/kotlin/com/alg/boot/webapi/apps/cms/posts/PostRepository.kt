package com.alg.boot.webapi.apps.cms.posts

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
interface PostRepository: JpaRepository<Post, Long>
