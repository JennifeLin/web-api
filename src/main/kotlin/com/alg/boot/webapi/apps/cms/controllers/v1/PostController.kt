package com.alg.boot.webapi.apps.cms.controllers.v1

import com.alg.boot.webapi.apps.cms.posts.dto.*
import com.alg.boot.webapi.apps.cms.posts.service.PostService
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import com.alg.boot.webapi.utils.AppConst
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/api/v1/posts")
class PostController(
    private val postService: PostService
) {
    @GetMapping
    fun getPosts(
        @RequestParam(value = "page", defaultValue = AppConst.PAGE_NUMBER, required = false) page: Int,
        @RequestParam(value = "size", defaultValue = AppConst.PAGE_SIZE, required = false) size: Int,
        @RequestParam(value = "sort", defaultValue = AppConst.SORT_BY, required = false) sort: String,
        @RequestParam(value = "direction", defaultValue = AppConst.SORT_DIRECTION, required = false) direction: String,
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
