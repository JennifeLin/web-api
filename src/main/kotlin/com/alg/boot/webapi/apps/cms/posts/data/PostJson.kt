package com.alg.boot.webapi.apps.cms.posts.data

import com.alg.boot.webapi.apps.cms.sites.data.SeoJson
import com.alg.boot.webapi.apps.cms.sites.data.SiteJson
import com.alg.boot.webapi.apps.content.comments.data.CommentJson
import com.alg.boot.webapi.enums.Status
import java.time.Instant
import java.time.LocalDate

class PostJson {
    var id: Long? = null
    var slug: String? = null
    var title: String? = null
    var summary: String? = null
    var content: String? = null
    var cover: String? = null
    var status: Status? = null
    var category: CategoryJson? = null
    var tags: MutableList<TagJson> = mutableListOf()
    var publishedAt: LocalDate? = null
    var isPublished: Boolean? = null
    var site: SiteJson? = null
    var seo: SeoJson? = null
    var comments: List<CommentJson> = emptyList()
    var createdAt: Instant? = null
    var updatedAt: Instant? = null
}
