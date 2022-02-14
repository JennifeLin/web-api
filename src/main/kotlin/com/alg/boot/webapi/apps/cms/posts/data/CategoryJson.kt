package com.alg.boot.webapi.apps.cms.posts.data

import java.time.Instant

class CategoryJson {
    var id: Long? = null
    var name: String? = null
    var slug: String? = null
    var description: String? = null
    var createdAt: Instant? = null
    var updatedAt: Instant? = null
}
