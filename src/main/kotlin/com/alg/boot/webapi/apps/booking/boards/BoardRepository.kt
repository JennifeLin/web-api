package com.alg.boot.webapi.apps.booking.boards

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BoardRepository : JpaRepository<Board, Long> {
    override fun findById(id: Long): Optional<Board>
}
