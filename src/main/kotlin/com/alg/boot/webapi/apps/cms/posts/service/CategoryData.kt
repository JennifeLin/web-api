package com.alg.boot.webapi.apps.cms.posts.service

import com.alg.boot.webapi.apps.cms.posts.Category
import com.alg.boot.webapi.apps.cms.posts.CategoryRepository
import com.alg.boot.webapi.apps.cms.posts.dto.CategoryRequestJson
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class CategoryData(val categoryRepository: CategoryRepository, val modelMapper: ModelMapper): CategoryService {
    override fun create(categoryRequest: CategoryRequestJson): Category {
        val category = modelMapper.map(categoryRequest, Category::class.java)
        return categoryRepository.saveAndFlush(category)
    }
}
