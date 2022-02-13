package com.alg.boot.webapi.apps.ats.jobs

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "jobs", path = "jobs")
interface JobRepository: JpaRepository<Job, Long>
