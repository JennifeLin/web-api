package com.alg.boot.webapi.apps.cms.posts.dto

import javax.validation.constraints.NotBlank

class TagRequestJson {
    @NotBlank
    var name: String? = null
}
