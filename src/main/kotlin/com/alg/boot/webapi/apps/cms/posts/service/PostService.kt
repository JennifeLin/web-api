package com.alg.boot.webapi.apps.cms.posts.service

import com.alg.boot.webapi.apps.cms.posts.data.PostAllResponseJson
import com.alg.boot.webapi.apps.cms.posts.data.PostJson
import com.alg.boot.webapi.apps.content.comments.data.CommentJson

interface PostService {
    fun create(post: PostJson): PostJson?
    fun all(page: Int, size: Int, sort: String, sortDir: String): PostAllResponseJson
    fun get(id: Long): PostJson?
    fun delete(id: Long): Boolean
    fun getComments(postId: Long): List<CommentJson>
    fun addComment(postId: Long, comment: CommentJson): CommentJson?
}
