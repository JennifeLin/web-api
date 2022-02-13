package com.alg.boot.webapi.apps.ats.profiles

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
interface ProjectRepository: JpaRepository<Project, Long>
