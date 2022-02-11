package com.alg.boot.webapi.apps.booking.boards

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "boards", path = "boards")
interface BoardRepository : JpaRepository<Board, Long> {
    override fun findById(id: Long): Optional<Board>
}
