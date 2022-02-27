package com.alg.boot.webapi.apps.cms.controllers.v1

import com.alg.boot.webapi.apps.cms.posts.dto.*
import com.alg.boot.webapi.apps.cms.posts.service.PostService
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import com.arthurolg.constants.Constants
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/posts")
class PostController(
    private val postService: PostService
) {
    @GetMapping
    fun getPosts(
        @RequestParam(value = "page", defaultValue = Constants.PAGE_NUMBER, required = false) page: Int,
        @RequestParam(value = "size", defaultValue = Constants.PAGE_SIZE, required = false) size: Int,
        @RequestParam(value = "sort", defaultValue = Constants.SORT_BY, required = false) sort: String,
        @RequestParam(value = "direction", defaultValue = Constants.SORT_DIRECTION, required = false) direction: String,
    ): GeneralResponse<PostPageResponseJson> =
        GeneralResponse(HttpStatus.OK.value(), postService.all(page, size, sort, direction))

    @GetMapping("/{slug}")
    fun getPostBySlug(@PathVariable slug: String): GeneralResponse<PostDetailResponseJson?> =
        GeneralResponse(HttpStatus.OK.value(), postService.getBySlug(slug))

    @PostMapping
    fun createPost(@Valid @RequestBody post: PostCreateRequestJson): GeneralResponse<PostResponseJson?> =
        GeneralResponse(HttpStatus.OK.value(), postService.create(post))

    @PutMapping("/{slug}")
    fun updatePost(@PathVariable slug: String, @Valid @RequestBody post: PostUpdateRequestJson): GeneralResponse<PostResponseJson?> =
        GeneralResponse(HttpStatus.OK.value(), postService.update(slug, post))

    @DeleteMapping("/{slug}")
    fun deletePost(@PathVariable slug: String): GeneralResponse<Boolean> =
        GeneralResponse(HttpStatus.OK.value(), postService.delete(slug))

}
