package com.alg.boot.webapi.apps.content.comments.service

import com.alg.boot.webapi.apps.cms.posts.PostRepository
import com.alg.boot.webapi.apps.cms.posts.service.PostData
import com.alg.boot.webapi.apps.content.comments.Comment
import com.alg.boot.webapi.apps.content.comments.CommentRepository
import com.alg.boot.webapi.apps.content.comments.dto.CommentRequestJson
import com.alg.boot.webapi.apps.content.comments.dto.CommentResponseJson
import com.alg.boot.webapi.handlers.exceptions.BadRequestException
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CommentData(
    val commentRepository: CommentRepository,
    val modelMapper: ModelMapper,
    val postRepository: PostRepository,
    val postData: PostData
    ): CommentService {

    override fun getPostComments(slug: String): List<CommentResponseJson> {
        val post = postData.findPostBySlug(slug)
        return post.comments.stream().map { comment ->
            modelMapper.map(comment, CommentResponseJson::class.java)
        }.collect(Collectors.toList())
    }

    override fun addPostComment(slug: String, commentRequest: CommentRequestJson): CommentResponseJson {
        val post = postData.findPostBySlug(slug)
        val comment = modelMapper.map(commentRequest, Comment::class.java)
        val commentSaved = commentRepository.save(comment)
        val comments = post.comments.toMutableList()
        comments.add(commentSaved)
        post.comments = comments
        postRepository.save(post)
        return modelMapper.map(commentSaved, CommentResponseJson::class.java)
    }

    override fun editPostComment(
        slug: String,
        commentId: Long,
        commentRequest: CommentRequestJson
    ): CommentResponseJson {
        if (postRepository.countBySlug(slug) == 0) throw BadRequestException("Post $slug not exists")
        val id = commentRepository.findById(commentId)
            .orElseThrow { BadRequestException("Comment $commentId not exists") }.id
        val comment = modelMapper.map(commentRequest, Comment::class.java)
        comment.id = id
        val commentSaved = commentRepository.save(comment)
        return modelMapper.map(commentSaved, CommentResponseJson::class.java)
    }

}
