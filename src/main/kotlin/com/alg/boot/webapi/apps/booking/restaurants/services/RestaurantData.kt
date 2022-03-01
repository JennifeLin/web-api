package com.alg.boot.webapi.apps.booking.restaurants.services

import com.alg.boot.webapi.apps.booking.restaurants.RestaurantRepository
import com.alg.boot.webapi.apps.booking.restaurants.data.RestaurantDetailJson
import com.alg.boot.webapi.apps.booking.restaurants.data.RestaurantJson
import com.alg.boot.webapi.handlers.exceptions.NotFoundException
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class RestaurantData(private val restaurantRepository: RestaurantRepository) : RestaurantService {

    companion object {
        private val modelMapper: ModelMapper = ModelMapper()
    }

    override fun getRestaurants(): List<RestaurantJson> {
        val restaurants = restaurantRepository.findAll()
        return restaurants.map { modelMapper.map(it, RestaurantJson::class.java) }
    }

    override fun getRestaurant(id: Long): RestaurantDetailJson {
        val restaurant = restaurantRepository.findById(id).orElseThrow {
            throw NotFoundException("Restaurant with id $id not found")
        }
        return modelMapper.map(restaurant, RestaurantDetailJson::class.java)
    }
}
