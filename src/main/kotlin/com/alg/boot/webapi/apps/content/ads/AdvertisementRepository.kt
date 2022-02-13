package com.alg.boot.webapi.apps.content.ads

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "ads", path = "ads")
interface AdvertisementRepository: JpaRepository<Advertisement, Long>
