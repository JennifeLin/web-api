package com.alg.boot.webapi.apps.cms.sites.data

import java.time.Instant

class SeoJson {
    var id: Long? = null
    var title: String? = null
    var description: String? = null
    var subject: String? = null
    var canonicalUrl: String? = null
    var robots: String? = null
    var classification: String? = null
    var image: String? = null
    var author: String? = null
    var copyright: String? = null
    var rating: Int = 0
    var facebookTitle: String? = null
    var facebookDescription: String? = null
    var facebookImage: String? = null
    var twitterTitle: String? = null
    var twitterDescription: String? = null
    var twitterImage: String? = null
    var twitterHashtag: String? = null
    var twitterAuthor: String? = null
    var createdAt: Instant? = null
    var updatedAt: Instant? = null
}
