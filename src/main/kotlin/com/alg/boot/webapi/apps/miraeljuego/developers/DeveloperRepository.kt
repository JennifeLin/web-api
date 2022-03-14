package com.alg.boot.webapi.apps.miraeljuego.developers

import org.springframework.data.jpa.repository.JpaRepository

interface DeveloperRepository: JpaRepository<Developer, Long>
