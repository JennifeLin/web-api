package com.alg.boot.webapi.apps.booking.turns

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TurnRepository : JpaRepository<Turn, Long> {
    override fun findById(id: Long): Optional<Turn>
    fun findByName(name: String): Optional<Turn>
}
