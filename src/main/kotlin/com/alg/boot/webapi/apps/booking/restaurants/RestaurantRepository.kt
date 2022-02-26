package com.alg.boot.webapi.apps.booking.restaurants

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.transaction.annotation.Transactional
import java.util.*


@RepositoryRestResource(collectionResourceRel = "restaurants", path = "restaurants")
interface RestaurantRepository : JpaRepository<Restaurant, Long> {
    @Transactional(readOnly = true)
    override fun findById(id: Long): Optional<Restaurant>
    @Transactional(readOnly = true)
    fun findByName(name: String): Optional<Restaurant>
}
