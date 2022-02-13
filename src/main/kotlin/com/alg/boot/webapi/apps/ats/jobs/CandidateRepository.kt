package com.alg.boot.webapi.apps.ats.jobs

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "jobs-candidates", path = "jobs-candidates")
interface CandidateRepository: JpaRepository<Candidate, Long>
