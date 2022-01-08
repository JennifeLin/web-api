package com.alg.boot.webapi.booking.boards

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BoardRepository : JpaRepository<Board, Long> {
    override fun findById(id: Long): Optional<Board>
}