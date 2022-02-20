package com.alg.boot.webapi.apps.cms.posts.service

import com.alg.boot.webapi.apps.cms.posts.Post
import com.alg.boot.webapi.apps.cms.posts.dto.*

interface PostService {
    fun create(postRequest: PostCreateRequestJson): PostResponseJson?
    fun update(slug: String, postRequest: PostUpdateRequestJson): PostResponseJson?
    fun all(page: Int, size: Int, sort: String, sortDir: String): PostPageResponseJson
    fun get(id: Long): PostResponseJson?
    fun getBySlug(slug: String): PostDetailResponseJson?
    fun delete(slug: String): Boolean
    fun findPostBySlug(slug: String): Post
    fun findPostById(id: Long): Post
}
