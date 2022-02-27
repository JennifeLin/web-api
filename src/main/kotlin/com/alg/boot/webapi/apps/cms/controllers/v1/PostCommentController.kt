package com.alg.boot.webapi.apps.cms.controllers.v1

import com.alg.boot.webapi.apps.content.comments.dto.CommentRequestJson
import com.alg.boot.webapi.apps.content.comments.dto.CommentResponseJson
import com.alg.boot.webapi.apps.content.comments.service.CommentData
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/posts")
class PostCommentController(
    private val commentData: CommentData
) {
    @GetMapping("/{slug}/comments")
    fun getPostComments(@PathVariable slug: String): GeneralResponse<List<CommentResponseJson>> =
        GeneralResponse(HttpStatus.OK.value(), commentData.getPostComments(slug))

    @PostMapping("/{slug}/comments")
    fun addComment(@PathVariable slug: String, @Valid @RequestBody comment: CommentRequestJson): GeneralResponse<CommentResponseJson?> =
        GeneralResponse(HttpStatus.OK.value(), commentData.addPostComment(slug, comment))

    @PutMapping("/{slug}/comments/{commentId}")
    fun editComment(@PathVariable slug: String, @PathVariable commentId: Long, @Valid @RequestBody comment: CommentRequestJson): GeneralResponse<CommentResponseJson?> =
        GeneralResponse(HttpStatus.OK.value(), commentData.editPostComment(slug, commentId, comment))
}
