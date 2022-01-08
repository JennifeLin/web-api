package com.alg.boot.webapi.booking.turns

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TurnRepository : JpaRepository<Turn, Long> {
    override fun findById(id: Long): Optional<Turn>
    fun findByName(name: String): Optional<Turn>
}