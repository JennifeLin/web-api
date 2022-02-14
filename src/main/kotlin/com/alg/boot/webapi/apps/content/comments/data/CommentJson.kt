package com.alg.boot.webapi.apps.content.comments.data

import java.time.Instant

class CommentJson {
    var id: Long? = null
    var subject: String? = null
    var content: String? = null
    var isApproved: Boolean? = null
    var likes: Int = 0
    var author: String? = null
    var email: String? = null
    var url: String? = null
    var createdAt: Instant? = null
    var updatedAt: Instant? = null
}
