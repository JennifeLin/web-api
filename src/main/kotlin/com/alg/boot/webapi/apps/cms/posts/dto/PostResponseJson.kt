package com.alg.boot.webapi.apps.cms.posts.dto

import com.alg.boot.webapi.apps.cms.sites.data.SiteJson
import com.alg.boot.webapi.enums.Status
import java.time.LocalDate

class PostResponseJson {
    var slug: String? = null
    var title: String? = null
    var summary: String? = null
    var content: String? = null
    var cover: String? = null
    var status: Status? = null
    var category: CategoryJson? = null
    var tags: MutableList<TagJson> = mutableListOf()
    var publishedAt: LocalDate? = null
    var site: SiteJson? = null
}
