package com.alg.boot.webapi.booking.restaurants

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RestaurantRepository : JpaRepository<Restaurant, Long> {
    override fun findById(id: Long): Optional<Restaurant>
    fun findByName(name: String): Optional<Restaurant>
}