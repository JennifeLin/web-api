package com.alg.boot.webapi.apps.content.comments.data

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class CommentJson {
    var id: Long? = null
    @NotBlank
    @Size(max = 160)
    var subject: String? = null
    @NotBlank
    @Size(max = 1000)
    var content: String? = null
    var likes: Int = 0
    var author: String? = null
    var email: String? = null
    var url: String? = null
}
