package com.alg.boot.webapi.apps.booking.restaurants.services

import com.alg.boot.webapi.apps.booking.restaurants.Restaurant
import com.alg.boot.webapi.apps.booking.restaurants.RestaurantRepository
import com.alg.boot.webapi.apps.booking.restaurants.data.RestaurantJson
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

internal class RestaurantDataTest {
    @Mock
    private lateinit var restaurantRepository: RestaurantRepository
    @InjectMocks
    private lateinit var restaurantData: RestaurantData

    @BeforeEach
    @Throws(GeneralException::class)
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    @Throws(GeneralException::class)
    fun getRestaurantTest() {
        Mockito.`when`(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT))
        restaurantData.getRestaurant(RESTAURANT_ID)
    }

    @Test
    @Throws(GeneralException::class)
    fun getRestaurantNotFoundTest() {
        Mockito.`when`(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.empty())
        Assertions.assertThrows(GeneralException::class.java) {
            restaurantData.getRestaurant(RESTAURANT_ID)
        }
    }

    @Test
    @Throws(GeneralException::class)
    fun getRestaurantsTest() {
        Mockito.`when`(restaurantRepository.findAll()).thenReturn(RESTAURANTS)
        val restaurants: List<RestaurantJson> = restaurantData.getRestaurants()
        Assertions.assertNotNull(restaurants)
        Assertions.assertFalse(restaurants.isEmpty())
        Assertions.assertEquals(RESTAURANTS.size, restaurants.size)
    }

    companion object {
        private const val RESTAURANT_ID: Long = 1L
        private val RESTAURANT: Restaurant = Restaurant(
            id = RESTAURANT_ID,
            name = "Restaurant",
            address = "Restaurant address",
            description = "Restaurant description",
            image = "Restaurant image",
            reservations = emptyList(),
            boards = emptyList(),
            turns = emptyList(),
        )
        private val RESTAURANTS: List<Restaurant> = listOf(RESTAURANT)
    }
}
