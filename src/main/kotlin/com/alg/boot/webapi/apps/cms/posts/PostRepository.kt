package com.alg.boot.webapi.apps.cms.posts

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import java.util.*


@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
interface PostRepository: JpaRepository<Post, Long> {
    @RestResource(path = "count-by-slug", rel = "count-by-slug")
    fun countBySlug(@Param("slug") slug: String): Int

    @RestResource(path = "find-by-slug", rel = "find-by-slug")
    fun findBySlug(@Param("slug") slug: String): Optional<Post>

    @RestResource(path = "title-starts-with", rel = "title-starts-with")
    fun findAllByTitleStartsWith(@Param("title") title: String?, p: Pageable?): Page<List<Post>>?
}
