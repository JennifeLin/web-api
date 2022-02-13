package com.alg.boot.webapi.apps.miraeljuego.games

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "games", path = "games")
interface GameRepository: JpaRepository<Game, Long>
