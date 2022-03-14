package com.alg.boot.webapi.apps.content.ads

import org.springframework.data.jpa.repository.JpaRepository

interface AdvertisementRepository: JpaRepository<Advertisement, Long>
