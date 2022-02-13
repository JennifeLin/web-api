package com.alg.boot.webapi.apps.miraeljuego.publishers

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "publishers", path = "publishers")
interface PublisherRepository: JpaRepository<Publisher, Long>
