package com.alg.boot.webapi.apps.booking.turns

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "turns", path = "turns")
interface TurnRepository : JpaRepository<Turn, Long> {
    override fun findById(id: Long): Optional<Turn>
    fun findByName(name: String): Optional<Turn>
}
