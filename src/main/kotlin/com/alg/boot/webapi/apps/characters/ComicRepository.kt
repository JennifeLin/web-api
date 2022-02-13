package com.alg.boot.webapi.apps.characters

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "comics", path = "comics")
interface ComicRepository: JpaRepository<Comic, Long>
