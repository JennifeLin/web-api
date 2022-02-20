package com.alg.boot.webapi.apps.content.comments.dto

import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class CommentJson {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var id: Long? = null
    @NotBlank
    @Size(max = 160)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var subject: String? = null
    @NotBlank
    @Size(max = 1000)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var content: String? = null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var likes: Int? = null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var author: String? = null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var email: String? = null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var url: String? = null
}
