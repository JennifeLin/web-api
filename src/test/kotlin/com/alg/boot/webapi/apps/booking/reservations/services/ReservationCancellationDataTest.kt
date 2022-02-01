package com.alg.boot.webapi.apps.booking.reservations.services

import com.alg.boot.webapi.apps.booking.reservations.Reservation
import com.alg.boot.webapi.apps.booking.reservations.ReservationRepository
import com.alg.boot.webapi.apps.booking.restaurants.Restaurant
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.exceptions.base.MockitoException
import java.util.*

internal class ReservationCancellationDataTest {

    @Mock
    private lateinit var reservationRepository: ReservationRepository
    @InjectMocks
    private lateinit var reservationCancellationData: ReservationCancellationData

    @BeforeEach
    @Throws(GeneralException::class)
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    @Throws(GeneralException::class)
    fun cancelReservationTest() {
        Mockito.`when`(reservationRepository.findByLocator(LOCATOR)).thenReturn(Optional.of(RESERVATION))
        Mockito.doNothing().`when`(reservationRepository).deleteByLocator(LOCATOR)
        val response = reservationCancellationData.cancelReservation(LOCATOR)
        Assertions.assertEquals("LOCATOR_${LOCATOR}_CANCELED", response)
    }

    @Test
    @Throws(GeneralException::class)
    fun cancelReservationTest_LocatorNotFound() {
        Mockito.`when`(reservationRepository.findByLocator(LOCATOR)).thenReturn(Optional.empty())
        Assertions.assertThrows(GeneralException::class.java) {
            reservationCancellationData.cancelReservation(LOCATOR)
        }
    }

    @Test
    @Throws(GeneralException::class)
    fun cancelReservationTest_InternalServerError() {
        Mockito.`when`(reservationRepository.findByLocator(LOCATOR)).thenReturn(Optional.of(RESERVATION))
        Mockito.doThrow(MockitoException::class.java).`when`(reservationRepository).deleteByLocator(LOCATOR)
        Assertions.assertThrows(GeneralException::class.java) {
            reservationCancellationData.cancelReservation(LOCATOR)
        }
    }

    companion object {
        private const val LOCATOR = "LOCATOR"
        private val RESTAURANT = Restaurant(
            id = 1L,
            name = "Restaurant",
            address = "Address",
            description = "Description",
            image = "Image",
        )
        private val RESERVATION = Reservation(
            id = 1,
            locator = LOCATOR,
            turn = "TURN",
            person = 2L,
            date = Date(),
            restaurant = RESTAURANT
        )
    }
}
