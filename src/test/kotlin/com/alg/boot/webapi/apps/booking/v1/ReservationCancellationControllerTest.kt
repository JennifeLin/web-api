package com.alg.boot.webapi.apps.booking.v1

import com.alg.boot.webapi.apps.booking.reservations.services.ReservationCancellationService
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class ReservationCancellationControllerTest {

    @Mock
    private lateinit var reservationCancellationService: ReservationCancellationService
    @InjectMocks
    private lateinit var reservationCancellationController: ReservationCancellationController

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    @Throws(GeneralException::class)
    fun cancel() {
        Mockito.`when`(reservationCancellationService.cancelReservation(LOCATOR)).thenReturn(LOCATOR_RESPONSE)
        val response = reservationCancellationController.cancel(LOCATOR)
        Assertions.assertEquals(SUCCESS_STATUS, response.status)
        Assertions.assertEquals(SUCCESS_CODE, response.code)
        Assertions.assertEquals(SUCCESS_MESSAGE, response.message)
        Assertions.assertEquals(LOCATOR_RESPONSE, response.data)
    }

    companion object {
        private const val LOCATOR = "LOCATOR 1_1"
        private const val LOCATOR_RESPONSE = "LOCATOR_${LOCATOR}_CANCELED"
        private const val SUCCESS_STATUS: String = "success"
        private const val SUCCESS_CODE: Int = 200
        private const val SUCCESS_MESSAGE: String = "OK"
    }
}
