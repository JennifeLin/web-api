package com.alg.boot.webapi.apps.ats.companies

import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository: JpaRepository<Company, Long>
