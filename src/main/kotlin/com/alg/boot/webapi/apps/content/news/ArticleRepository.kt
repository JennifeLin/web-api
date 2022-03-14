package com.alg.boot.webapi.apps.content.news

import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository: JpaRepository<Article, Long>
