package com.alg.boot.webapi.booking.v1

import com.alg.boot.webapi.booking.restaurants.data.RestaurantDetailJson
import com.alg.boot.webapi.booking.restaurants.services.RestaurantService
import com.alg.boot.webapi.booking.turns.data.TurnJson
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
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
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(restaurantService.getRestaurant(1)).thenReturn(RESTAURANT_DETAIL_JSON)
    }

    @Test
    @Throws(GeneralException::class)
    fun getRestaurantTest() {
        val response: GeneralResponse<RestaurantDetailJson> = restaurantController.getRestaurant(RESTAURANT_ID)
        Assertions.assertEquals(SUCCESS_STATUS, response.status)
        Assertions.assertEquals(SUCCESS_CODE, response.code)
        Assertions.assertEquals(SUCCESS_MESSAGE, response.message)
        Assertions.assertEquals(RESTAURANT_DETAIL_JSON, response.data)
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
    }
}
