package com.alg.boot.webapi.apps.cms.posts.dto

import com.alg.boot.webapi.apps.cms.sites.data.SeoRequestJson
import org.hibernate.validator.constraints.URL
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class PostCreateRequestJson {
    @NotBlank
    lateinit var domain: String
    @NotBlank
    @Size(min = 4, max = 160)
    var title: String? = null
    @NotBlank
    @Size(max = 600)
    var summary: String? = null
    @NotEmpty
    var content: String? = null
    @URL
    var cover: String? = null
    var category: CategoryRequestJson? = null
    var publishedAt: LocalDate? = null
    var isPublished: Boolean? = null
    var seo: SeoRequestJson? = null
    var tags: MutableList<TagRequestJson> = mutableListOf()
}
