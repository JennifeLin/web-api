package com.alg.boot.webapi.apps.cms.posts

import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository: JpaRepository<Tag, Long>
