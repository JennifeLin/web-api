package com.alg.boot.webapi.apps.content.galleries

import org.springframework.data.jpa.repository.JpaRepository

interface GalleryRepository: JpaRepository<Gallery, Long>
