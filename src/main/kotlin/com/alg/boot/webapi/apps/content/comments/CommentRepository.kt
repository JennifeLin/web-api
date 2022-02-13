package com.alg.boot.webapi.apps.content.comments

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
interface CommentRepository: JpaRepository<Comment, Long>
