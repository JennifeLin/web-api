package com.alg.boot.webapi.apps.miraeljuego.consoles

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "consoles", path = "consoles")
interface ConsoleRepository: JpaRepository<Console, Long>
