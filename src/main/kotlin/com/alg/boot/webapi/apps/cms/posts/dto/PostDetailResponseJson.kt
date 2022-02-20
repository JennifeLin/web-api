package com.alg.boot.webapi.apps.cms.posts.dto

import com.alg.boot.webapi.apps.cms.posts.Category
import com.alg.boot.webapi.apps.cms.posts.Tag
import com.alg.boot.webapi.apps.cms.sites.Seo
import com.alg.boot.webapi.apps.cms.sites.Site
import com.alg.boot.webapi.apps.content.comments.Comment
import com.arthurolg.enums.Status
import java.time.LocalDateTime

class PostDetailResponseJson {
    var title: String? = null
    var summary: String? = null
    var content: String? = null
    var cover: String? = null
    var status: Status? = null
    var category: Category? = null
    var tags: MutableList<Tag> = mutableListOf()
    var isPublished: Boolean? = null
    var site: Site? = null
    var seo: Seo? = null
    var comments: List<Comment> = emptyList()
    var createdAt: LocalDateTime? = null
    var updatedAt: LocalDateTime? = null
}
