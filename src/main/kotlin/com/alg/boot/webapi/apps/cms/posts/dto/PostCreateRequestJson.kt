package com.alg.boot.webapi.apps.cms.posts.dto

import com.alg.boot.webapi.apps.cms.sites.data.SeoRequestJson
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class PostCreateRequestJson(
    @NotBlank
    val domain: String,
    @NotBlank
    @Size(max = 160)
    val title: String,
    @NotBlank
    @Size(max = 600)
    val summary: String,
    var content: String? = null,
    var cover: String? = null,
    var category: CategoryRequestJson? = null,
    var publishedAt: LocalDate? = null,
    var isPublished: Boolean? = null,
    var seo: SeoRequestJson? = null,
    var tags: MutableList<TagRequestJson> = mutableListOf(),
)
