package com.alg.boot.webapi.apps.booking.reservations.services

import com.alg.boot.webapi.apps.booking.reservations.Reservation
import com.alg.boot.webapi.apps.booking.reservations.ReservationRepository
import com.alg.boot.webapi.apps.booking.reservations.data.ReservationCreateJson
import com.alg.boot.webapi.apps.booking.restaurants.Restaurant
import com.alg.boot.webapi.apps.booking.restaurants.RestaurantRepository
import com.alg.boot.webapi.apps.booking.turns.Turn
import com.alg.boot.webapi.apps.booking.turns.TurnRepository
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

internal class ReservationDataTest {
    @Mock
    private lateinit var reservationRepository: ReservationRepository
    @Mock
    private lateinit var restaurantRepository: RestaurantRepository
    @Mock
    private lateinit var turnRepository: TurnRepository
    @InjectMocks
    private lateinit var reservationData: ReservationData

    @BeforeEach
    @Throws(GeneralException::class)
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    @Throws(GeneralException::class)
    fun getReservationTest() {
        Mockito.`when`(reservationRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESERVATION))
        val result = reservationData.getReservation(RESTAURANT_ID)
        Assertions.assertNotNull(result)
    }

    @Test
    @Throws(GeneralException::class)
    fun createReservationTest() {
        Mockito.`when`(turnRepository.findById(TURN_ID)).thenReturn(Optional.of(TURN))
        Mockito.`when`(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT))
        Mockito.`when`(reservationRepository.findByTurnAndRestaurantId(TURN_NAME, RESTAURANT_ID)).thenReturn(Optional.empty())
        Mockito.`when`(reservationRepository.save(Mockito.any(Reservation::class.java))).thenReturn(
            Reservation()
        )
        reservationData.createReservation(RESERVATION_CREATE_JSON)
    }

    @Test
    @Throws(GeneralException::class)
    fun createReservationTest_TurnNotFound() {
        Mockito.`when`(turnRepository.findById(TURN_ID)).thenReturn(Optional.empty())
        Assertions.assertThrows(GeneralException::class.java) {
            reservationData.createReservation(RESERVATION_CREATE_JSON)
        }
    }

    @Test
    @Throws(GeneralException::class)
    fun createReservationTest_RestaurantNotFound() {
        Mockito.`when`(turnRepository.findById(TURN_ID)).thenReturn(Optional.of(TURN))
        Mockito.`when`(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.empty())
        Assertions.assertThrows(GeneralException::class.java) {
            reservationData.createReservation(RESERVATION_CREATE_JSON)
        }
    }

    @Test
    @Throws(GeneralException::class)
    fun createReservationTest_ReservationAlreadyExists() {
        Mockito.`when`(turnRepository.findById(TURN_ID)).thenReturn(Optional.of(TURN))
        Mockito.`when`(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT))
        Mockito.`when`(reservationRepository.findByTurnAndRestaurantId(TURN_NAME, RESTAURANT_ID)).thenReturn(Optional.of(
            RESERVATION
        ))
        Assertions.assertThrows(GeneralException::class.java) {
            reservationData.createReservation(RESERVATION_CREATE_JSON)
        }
    }

    @Test
    @Throws(GeneralException::class)
    fun createReservationTest_TurnNameIsNull_RestaurantIdIsNull() {
        Mockito.`when`(turnRepository.findById(TURN_ID)).thenReturn(Optional.of(TURN_WITHOUT_TURN_NAME))
        Mockito.`when`(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT_WITHOUT_ID))
        Assertions.assertThrows(GeneralException::class.java) {
            reservationData.createReservation(RESERVATION_CREATE_JSON)
        }
    }

    @Test
    @Throws(GeneralException::class)
    fun createReservationTest_Internal_Server_Error() {
        Mockito.`when`(turnRepository.findById(TURN_ID)).thenReturn(Optional.of(TURN))
        Mockito.`when`(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT))
        Mockito.`when`(reservationRepository.findByTurnAndRestaurantId(TURN_NAME, RESTAURANT_ID)).thenReturn(Optional.empty())
        Mockito.doThrow(MockitoException::class.java).`when`(reservationRepository).save(any(Reservation::class.java))
        Assertions.assertThrows(GeneralException::class.java) {
            reservationData.createReservation(RESERVATION_CREATE_JSON)
        }
    }

    private fun <T> any(type: Class<T>): T = Mockito.any(type)

    companion object {
        private const val RESTAURANT_ID = 1L
        private val RESTAURANT = Restaurant(
            id = RESTAURANT_ID,
            name = "Restaurant",
            address = "Restaurant address",
            description = "Restaurant description",
            image = "Restaurant image",
            reservations = mutableListOf(),
            boards = mutableListOf(),
            turns = mutableListOf(),
        )
        private val RESTAURANT_WITHOUT_ID = Restaurant(
            id = null,
            name = "Restaurant",
            address = "Restaurant address",
            description = "Restaurant description",
            image = "Restaurant image",
            reservations = mutableListOf(),
            boards = mutableListOf(),
            turns = mutableListOf(),
        )
        private const val TURN_ID = 1L
        private const val TURN_NAME = "Turn1_11-20"
        private val TURN = Turn(
            id = TURN_ID,
            name = TURN_NAME,
            restaurant = RESTAURANT,
        )
        private val TURN_WITHOUT_TURN_NAME = Turn(
            id = TURN_ID,
            name = null,
            restaurant = RESTAURANT,
        )
        private val RESERVATION_CREATE_JSON = ReservationCreateJson(
            turnId = 1L,
            restaurantId = RESTAURANT_ID,
            person = 2L,
            date = Date()
        )
        private val RESERVATION = Reservation(
            id = 1L,
            turn = TURN_NAME,
            locator = "${RESTAURANT.name}_${TURN.id}",
            restaurant = RESTAURANT,
            person = 2L,
            date = Date(),
        )
    }
}
