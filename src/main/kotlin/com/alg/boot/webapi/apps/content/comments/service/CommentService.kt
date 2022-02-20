package com.alg.boot.webapi.apps.content.comments.service

import com.alg.boot.webapi.apps.content.comments.dto.CommentRequestJson
import com.alg.boot.webapi.apps.content.comments.dto.CommentResponseJson

interface CommentService {
    fun getPostComments(slug: String): List<CommentResponseJson>
    fun addPostComment(slug: String, commentRequest: CommentRequestJson): CommentResponseJson
    fun editPostComment(slug: String, commentId: Long, commentRequest: CommentRequestJson): CommentResponseJson
}
