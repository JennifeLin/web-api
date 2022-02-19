package com.alg.boot.webapi.apps.cms.posts.data

import com.alg.boot.webapi.apps.cms.posts.Category
import com.alg.boot.webapi.apps.cms.posts.Tag
import com.alg.boot.webapi.apps.cms.sites.Seo
import com.alg.boot.webapi.apps.cms.sites.Site
import com.alg.boot.webapi.apps.content.comments.Comment
import com.alg.boot.webapi.enums.Status
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.Instant

class PostDetailJson {
    var title: String? = null
    var summary: String? = null
    var content: String? = null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var cover: String? = null
    var status: Status? = null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var category: Category? = null
    var tags: MutableList<Tag> = mutableListOf()
    var isPublished: Boolean? = null
    var site: Site? = null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var seo: Seo? = null
    var comments: List<Comment> = emptyList()
    var createdAt: Instant? = null
    var updatedAt: Instant? = null
}
