package com.alg.boot.webapi.apps.miraeljuego.games

import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository: JpaRepository<Game, Long>
