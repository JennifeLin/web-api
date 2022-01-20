package com.alg.boot.webapi.booking.v1

import com.alg.boot.webapi.booking.restaurants.data.RestaurantDetailJson
import com.alg.boot.webapi.booking.restaurants.data.RestaurantJson
import com.alg.boot.webapi.booking.restaurants.services.RestaurantService
import com.alg.boot.webapi.booking.turns.data.TurnJson
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class RestaurantControllerTest {

    @Mock
    private lateinit var restaurantService: RestaurantService
    @InjectMocks
    private lateinit var restaurantController: RestaurantController

    @BeforeEach
    @Throws(GeneralException::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(restaurantService.getRestaurant(1)).thenReturn(RESTAURANT_DETAIL_JSON)
        Mockito.`when`(restaurantService.getRestaurants()).thenReturn(RESTAURANT_JSON_LIST)
    }

    @Test
    @DisplayName("Get restaurant detail by id")
    @Throws(GeneralException::class)
    fun getRestaurantTest() {
        val response: GeneralResponse<RestaurantDetailJson> = restaurantController.getRestaurant(RESTAURANT_ID)
        Assertions.assertAll(
            { Assertions.assertEquals(SUCCESS_STATUS, response.status) },
            { Assertions.assertEquals(SUCCESS_CODE, response.code) },
            { Assertions.assertEquals(SUCCESS_MESSAGE, response.message) },
            {Assertions.assertEquals(RESTAURANT_DETAIL_JSON, response.data) }
        )
    }

    @Test
    @DisplayName("Get restaurants")
    @Throws(GeneralException::class)
    fun getRestaurantsTest() {
        val response: GeneralResponse<List<RestaurantJson>> = restaurantController.getRestaurants()
        Assertions.assertAll(
            { Assertions.assertEquals(SUCCESS_STATUS, response.status) },
            { Assertions.assertEquals(SUCCESS_CODE, response.code) },
            { Assertions.assertEquals(SUCCESS_MESSAGE, response.message) },
            { Assertions.assertEquals(RESTAURANT_JSON_LIST, response.data) }
        )
    }

    companion object {
        private const val RESTAURANT_ID: Long = 1L
        private const val SUCCESS_STATUS: String = "Success"
        private const val SUCCESS_CODE: Int = 200
        private const val SUCCESS_MESSAGE: String = "OK"
        private val TURN_LIST_JSON: List<TurnJson> = listOf(
            TurnJson(
                id = 1L,
                name = "Time 1"
            ),
            TurnJson(
                id = 2L,
                name = "Time 2"
            )
        )
        private val RESTAURANT_DETAIL_JSON: RestaurantDetailJson = RestaurantDetailJson(
            id = 1L,
            address = "Address 1",
            description = "Description 1",
            image = "Image 1",
            turns = TURN_LIST_JSON
        )
        private val RESTAURANT_JSON_LIST: List<RestaurantJson> = listOf(
            RestaurantJson(
                id = 1L,
                address = "Address 1",
                description = "Description 1",
                image = "Image 1"
            ),
            RestaurantJson(
                id = 2L,
                address = "Address 2",
                description = "Description 2",
                image = "Image 2"
            )
        )
    }
}
