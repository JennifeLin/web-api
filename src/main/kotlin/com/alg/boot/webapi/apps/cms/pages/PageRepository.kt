package com.alg.boot.webapi.apps.cms.pages

import org.springframework.data.jpa.repository.JpaRepository

interface PageRepository: JpaRepository<Page, Long>
