package com.alg.boot.webapi.apps.cms.posts.data

import com.alg.boot.webapi.apps.cms.sites.data.SeoJson
import com.alg.boot.webapi.apps.cms.sites.data.SiteJson
import com.alg.boot.webapi.enums.Status
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class PostJson {
    var id: Long? = null
    @NotBlank
    @Size(max = 160)
    var title: String? = null
    @NotBlank
    @Size(max = 600)
    var summary: String? = null
    var content: String? = null
    var cover: String? = null
    var status: Status? = null
    var category: CategoryJson? = null
    var tags: MutableList<TagJson> = mutableListOf()
    var publishedAt: LocalDate? = null
    var isPublished: Boolean? = null
    var seo: SeoJson? = null
    var site: SiteJson? = null
}
