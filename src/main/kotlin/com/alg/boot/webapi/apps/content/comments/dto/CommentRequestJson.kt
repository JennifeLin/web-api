package com.alg.boot.webapi.apps.content.comments.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class CommentRequestJson {
    @NotBlank
    @Size(max = 160)
    var subject: String? = null
    @NotBlank
    @Size(max = 1000)
    var content: String? = null
    var author: String? = null
    var email: String? = null
    var url: String? = null
}
