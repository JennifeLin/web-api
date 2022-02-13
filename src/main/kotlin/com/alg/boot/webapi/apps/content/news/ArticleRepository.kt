package com.alg.boot.webapi.apps.content.news

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "articles", path = "articles")
interface ArticleRepository: JpaRepository<Article, Long>
