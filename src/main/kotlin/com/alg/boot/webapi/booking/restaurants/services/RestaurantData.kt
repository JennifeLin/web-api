package com.alg.boot.webapi.booking.restaurants.services

import com.alg.boot.webapi.booking.restaurants.RestaurantRepository
import com.alg.boot.webapi.booking.restaurants.data.RestaurantDetailJson
import com.alg.boot.webapi.booking.restaurants.data.RestaurantJson
import com.alg.boot.webapi.handlers.exceptions.NotFoundException
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service


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
            throw NotFoundException("DATA_404", "Restaurant with id $id not found")
        }
        return modelMapper.map(restaurant, RestaurantDetailJson::class.java)
    }
}