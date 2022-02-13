package com.alg.boot.webapi.apps.miraeljuego.genres

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "genres", path = "genres")
interface GenreRepository: JpaRepository<Genre, Long>
