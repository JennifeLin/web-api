package com.alg.boot.webapi.apps.cms.posts.dto

class PostPageResponseJson {
    var content: List<PostResponseJson> = emptyList()
    var totalItems: Int = 0
    var totalPages: Int = 0
    var page: Int = 0
    var itemsOnPage: Int = 0
    var lastPage: Boolean = false
}
