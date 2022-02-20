package com.alg.boot.webapi.apps.cms.posts.service

import com.alg.boot.webapi.apps.cms.posts.Category
import com.alg.boot.webapi.apps.cms.posts.dto.CategoryRequestJson

interface CategoryService {
    fun create(categoryRequest: CategoryRequestJson): Category
}
