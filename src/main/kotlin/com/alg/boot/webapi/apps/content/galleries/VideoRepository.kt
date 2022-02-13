package com.alg.boot.webapi.apps.content.galleries

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "videos", path = "videos")
interface VideoRepository: JpaRepository<Video, Long>
