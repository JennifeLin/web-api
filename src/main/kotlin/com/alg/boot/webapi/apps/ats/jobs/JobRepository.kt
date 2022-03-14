package com.alg.boot.webapi.apps.ats.jobs

import org.springframework.data.jpa.repository.JpaRepository

interface JobRepository: JpaRepository<Job, Long>
