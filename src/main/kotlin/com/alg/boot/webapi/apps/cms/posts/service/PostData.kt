package com.alg.boot.webapi.apps.cms.posts.service

import com.alg.boot.webapi.apps.cms.posts.Post
import com.alg.boot.webapi.apps.cms.posts.PostRepository
import com.alg.boot.webapi.apps.cms.posts.data.PostDetailJson
import com.alg.boot.webapi.apps.cms.posts.data.PostJson
import com.alg.boot.webapi.apps.cms.posts.data.PostPageJson
import com.alg.boot.webapi.apps.cms.sites.SiteRepository
import com.alg.boot.webapi.apps.cms.sites.data.SiteJson
import com.alg.boot.webapi.apps.content.comments.Comment
import com.alg.boot.webapi.apps.content.comments.CommentRepository
import com.alg.boot.webapi.apps.content.comments.data.CommentJson
import com.alg.boot.webapi.handlers.exceptions.NotFoundException
import org.modelmapper.ModelMapper
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class PostData(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,
    private val siteRepository: SiteRepository
    ): PostService {

    companion object {
        private val modelMapper: ModelMapper = ModelMapper()
    }

    override fun create(post: PostJson): PostJson? {
        val site = post.site?.id?.let { siteRepository.findById(it).orElseThrow { NotFoundException("No hay sitio") } }
        post.site = modelMapper.map(site, SiteJson::class.java)
        val postData = modelMapper.map(post, Post::class.java)
        postData.slug = UUID.randomUUID().toString()
        val postSaved = postRepository.save(postData)
        return modelMapper.map(postSaved, PostJson::class.java)
    }

    override fun all(page: Int, size: Int, sort: String, sortDir: String): PostPageJson {
        var sortBy = Sort.by(sort).ascending()
        if (sortDir.contentEquals(Sort.Direction.DESC.name, true)) {
            sortBy = Sort.by(sort).descending()
        }
        val pageable = PageRequest.of(page, size, sortBy)
        val posts = postRepository.findAll(pageable)
        val content = posts.content.stream().map {
                post -> modelMapper.map(post, PostJson::class.java)
        }.collect(Collectors.toList())
        val response = PostPageJson()
        response.content = content
        response.page = posts.number
        response.itemsOnPage = posts.size
        response.totalItems = posts.numberOfElements
        response.totalPages = posts.totalPages
        response.lastPage = posts.isLast
        return response
    }

    override fun get(id: Long): PostJson? {
        return modelMapper.map(getPostById(id), PostJson::class.java)
    }

    override fun getBySlug(slug: String): PostDetailJson? {
        val post = postRepository.findBySlug(slug).orElseThrow {
            NotFoundException("No hay datos")
        }
        return modelMapper.map(post, PostDetailJson::class.java)
    }

    override fun delete(id: Long): Boolean {
        val post = getPostById(id)
        try {
            postRepository.delete(post)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun getComments(postId: Long): List<CommentJson> {
        val post = getPostById(postId)
        return post.comments.stream().map {
                comment -> modelMapper.map(comment, CommentJson::class.java)
        }.collect(Collectors.toList())
    }

    override fun addComment(postId: Long, comment: CommentJson): CommentJson? {
        val post = getPostById(postId)
        val commentData = modelMapper.map(comment, Comment::class.java)
        val commentSaved = commentRepository.save(commentData)
        val comments = post.comments.toMutableList()
        comments.add(commentSaved)
        post.comments = comments
        postRepository.save(post)
        return modelMapper.map(commentSaved, CommentJson::class.java)
    }

    override fun editComment(commentId: Long, comment: CommentJson): CommentJson {
        var commentData = commentRepository.findById(commentId).orElseThrow { NotFoundException("No hay comentario") }
        comment.id = commentData.id
        commentData = modelMapper.map(comment, Comment::class.java)
        val commentSaved = commentRepository.save(commentData)
        return modelMapper.map(commentSaved, CommentJson::class.java)
    }

    private fun getPostById(id: Long): Post {
        val post = postRepository.findById(id).orElseThrow {
            NotFoundException("No hay datos")
        }
        return post
    }
}
