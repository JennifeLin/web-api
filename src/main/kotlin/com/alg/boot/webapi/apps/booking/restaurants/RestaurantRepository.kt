package com.alg.boot.webapi.apps.booking.restaurants

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "restaurants", path = "restaurants")
interface RestaurantRepository : JpaRepository<Restaurant, Long> {
    override fun findById(id: Long): Optional<Restaurant>
    fun findByName(name: String): Optional<Restaurant>
}
