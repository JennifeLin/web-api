package com.alg.boot.webapi.booking.v1

import com.alg.boot.webapi.booking.reservations.data.ReservationCreateJson
import com.alg.boot.webapi.booking.reservations.data.ReservationJson
import com.alg.boot.webapi.booking.reservations.services.ReservationService
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

internal class ReservationControllerTest {
    @Mock
    private lateinit var reservationService: ReservationService
    @InjectMocks
    private lateinit var reservationController: ReservationController

    @BeforeEach
    @Throws(GeneralException::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(reservationService.createReservation(RESERVATION_CREATE_JSON)).thenReturn(LOCATOR_RESPONSE)
        Mockito.`when`(reservationService.getReservation(RESERVATION_ID)).thenReturn(RESERVATION_JSON)
    }

    @Test
    @Throws(GeneralException::class)
    fun getReservationTest() {
        val response = reservationController.getReservation(RESERVATION_ID)
        Assertions.assertEquals(SUCCESS_STATUS, response.status)
        Assertions.assertEquals(SUCCESS_CODE, response.code)
        Assertions.assertEquals(SUCCESS_MESSAGE, response.message)
        Assertions.assertEquals(RESERVATION_JSON, response.data)
    }

    @Test
    @Throws(GeneralException::class)
    fun createReservationTest() {
        val response: GeneralResponse<String> = reservationController.create(RESERVATION_CREATE_JSON)
        Assertions.assertEquals(SUCCESS_STATUS, response.status)
        Assertions.assertEquals(SUCCESS_CODE, response.code)
        Assertions.assertEquals(SUCCESS_MESSAGE, response.message)
        Assertions.assertEquals(LOCATOR_RESPONSE, response.data)
        Mockito.verify(reservationService).createReservation(RESERVATION_CREATE_JSON)
    }

    companion object {
        private const val RESERVATION_ID: Long = 1L
        private const val RESTAURANT_ID: Long = 1L
        private const val SUCCESS_STATUS: String = "Success"
        private const val SUCCESS_CODE: Int = 200
        private const val SUCCESS_MESSAGE: String = "OK"
        private const val LOCATOR_RESPONSE: String = "LOCATOR"
        private val RESERVATION_JSON: ReservationJson = ReservationJson(
            id = RESERVATION_ID,
            locator = "Locator1",
            turn = "Turn1",
            person = 3L,
            date = Date(),
            restaurantId = RESTAURANT_ID
        )
        private val RESERVATION_CREATE_JSON: ReservationCreateJson = ReservationCreateJson(
            turnId = 1L,
            restaurantId = 1L,
            person = 2L,
            date = Date()
        )
    }
}
