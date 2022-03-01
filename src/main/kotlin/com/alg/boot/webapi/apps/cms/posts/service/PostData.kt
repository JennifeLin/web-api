package com.alg.boot.webapi.apps.cms.posts.service

import com.alg.boot.webapi.apps.cms.posts.Post
import com.alg.boot.webapi.apps.cms.posts.PostRepository
import com.alg.boot.webapi.apps.cms.posts.dto.*
import com.alg.boot.webapi.apps.cms.sites.Site
import com.alg.boot.webapi.apps.cms.sites.SiteRepository
import com.alg.boot.webapi.handlers.exceptions.BadRequestException
import com.alg.boot.webapi.handlers.exceptions.NotFoundException
import org.modelmapper.ModelMapper
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Transactional
@Service
class PostData(
    private val modelMapper: ModelMapper,
    private val categoryData: CategoryData,
    private val postRepository: PostRepository,
    private val siteRepository: SiteRepository
    ): PostService {

    override fun create(postRequest: PostCreateRequestJson): PostResponseJson? {
        val site = siteRepository.findByDomain(postRequest.domain)
            .orElseThrow { BadRequestException("Domain ${postRequest.domain} not allowed") }
        val postData = modelMapper.map(postRequest, Post::class.java)
        postData.site = modelMapper.map(site, Site::class.java)
        postData.category = postRequest.category?.let { categoryData.create(it) }
        val postSaved = postRepository.save(postData)
        return modelMapper.map(postSaved, PostResponseJson::class.java)
    }

    override fun update(slug: String, postRequest: PostUpdateRequestJson): PostResponseJson? {
        val post = findPostBySlug(slug)
        modelMapper.map(postRequest, post)
        val postSaved = postRepository.save(post)
        return modelMapper.map(postSaved, PostResponseJson::class.java)
    }

    override fun all(page: Int, size: Int, sort: String, sortDir: String): PostPageResponseJson {
        var sortBy = Sort.by(sort).ascending()
        if (sortDir.contentEquals(Sort.Direction.DESC.name, true)) {
            sortBy = Sort.by(sort).descending()
        }
        val pageable = PageRequest.of(page, size, sortBy)
        val posts = postRepository.findAll(pageable)
        val content = posts.content.stream().map {
                post -> modelMapper.map(post, PostResponseJson::class.java)
        }.collect(Collectors.toList())
        val response = PostPageResponseJson()
        response.content = content
        response.page = posts.number
        response.itemsOnPage = posts.size
        response.totalItems = posts.numberOfElements
        response.totalPages = posts.totalPages
        response.lastPage = posts.isLast
        return response
    }

    override fun get(id: Long): PostResponseJson? {
        return modelMapper.map(findPostById(id), PostResponseJson::class.java)
    }

    override fun getBySlug(slug: String): PostDetailResponseJson? {
        val post = postRepository.findBySlug(slug).orElseThrow {
            NotFoundException("No hay datos")
        }
        return modelMapper.map(post, PostDetailResponseJson::class.java)
    }

    override fun delete(slug: String): Boolean {
        val post = findPostBySlug(slug)
        try {
            postRepository.delete(post)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun findPostBySlug(slug: String): Post {
        return postRepository.findBySlug(slug).orElseThrow {
            NotFoundException("Post $slug not found")
        }
    }

    override fun findPostById(id: Long): Post {
        return postRepository.findById(id).orElseThrow {
            NotFoundException("Post $id not found")
        }
    }
}
