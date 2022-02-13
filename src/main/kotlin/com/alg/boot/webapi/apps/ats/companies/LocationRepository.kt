package com.alg.boot.webapi.apps.ats.companies

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "locations", path = "locations")
interface LocationRepository: JpaRepository<Location, Long>
