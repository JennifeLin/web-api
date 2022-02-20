package com.alg.boot.webapi.apps.cms.posts.dto

import javax.validation.constraints.NotBlank

class CategoryRequestJson {
    @NotBlank
    var name: String? = null
    var description: String? = null
}
