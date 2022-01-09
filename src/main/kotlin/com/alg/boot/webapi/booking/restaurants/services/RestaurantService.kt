package com.alg.boot.webapi.booking.restaurants.services

import com.alg.boot.webapi.booking.restaurants.data.RestaurantDetailJson
import com.alg.boot.webapi.booking.restaurants.data.RestaurantJson
import com.alg.boot.webapi.handlers.exceptions.GeneralException

interface RestaurantService {
    @Throws(GeneralException::class)
    fun getRestaurants(): List<RestaurantJson>
    @Throws(GeneralException::class)
    fun getRestaurant(id: Long): RestaurantDetailJson
}