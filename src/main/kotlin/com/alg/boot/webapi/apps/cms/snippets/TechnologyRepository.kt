package com.alg.boot.webapi.apps.cms.snippets

import org.springframework.data.jpa.repository.JpaRepository

interface TechnologyRepository: JpaRepository<Technology, Long>
