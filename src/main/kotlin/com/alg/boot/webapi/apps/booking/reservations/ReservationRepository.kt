package com.alg.boot.webapi.apps.booking.reservations

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*
import javax.transaction.Transactional

@RepositoryRestResource(collectionResourceRel = "reservations", path = "reservations")
interface ReservationRepository : JpaRepository<Reservation, Long> {
    override fun findById(id: Long): Optional<Reservation>
    fun findByLocator(locator: String): Optional<Reservation>
    fun findByTurnAndRestaurantId(turn: String, restaurantId: Long): Optional<Reservation>
    @Modifying
    @Transactional
    fun deleteByLocator(locator: String)
}
