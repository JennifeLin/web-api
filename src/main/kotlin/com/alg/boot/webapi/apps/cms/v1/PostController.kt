package com.alg.boot.webapi.apps.cms.v1

import com.alg.boot.webapi.apps.cms.posts.data.PostAllResponseJson
import com.alg.boot.webapi.apps.cms.posts.data.PostJson
import com.alg.boot.webapi.apps.cms.posts.service.PostService
import com.alg.boot.webapi.apps.content.comments.data.CommentJson
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import com.alg.boot.webapi.utils.AppConst
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

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
    ): GeneralResponse<PostAllResponseJson> =
        GeneralResponse("success", HttpStatus.OK.value(), "OK", postService.all(page, size, sort, direction))

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): GeneralResponse<PostJson?> =
        GeneralResponse("success", HttpStatus.OK.value(), "OK", postService.get(id))

    @PostMapping
    fun createPost(@RequestBody post: PostJson): GeneralResponse<PostJson?> =
        GeneralResponse("success", HttpStatus.OK.value(), "OK", postService.create(post))

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): GeneralResponse<Boolean> =
        GeneralResponse("success", HttpStatus.OK.value(), "OK", postService.delete(id))


    @GetMapping("/{id}/comments")
    fun getPostComments(@PathVariable id: Long): GeneralResponse<List<CommentJson>> =
        GeneralResponse("success", HttpStatus.OK.value(), "OK", postService.getComments(id))

    @PostMapping("/{id}/comments")
    fun addComment(@PathVariable id: Long, @RequestBody comment: CommentJson): GeneralResponse<CommentJson?> =
        GeneralResponse("success", HttpStatus.OK.value(), "OK", postService.addComment(id, comment))
}
