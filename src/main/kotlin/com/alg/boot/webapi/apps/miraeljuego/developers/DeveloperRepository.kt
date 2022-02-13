package com.alg.boot.webapi.apps.miraeljuego.developers

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "developers", path = "developers")
interface DeveloperRepository: JpaRepository<Developer, Long>
