package com.alg.boot.webapi.apps.miraeljuego.genres

import org.springframework.data.jpa.repository.JpaRepository

interface GenreRepository: JpaRepository<Genre, Long>
