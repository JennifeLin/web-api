package com.alg.boot.webapi.booking.reservations.services

import com.alg.boot.webapi.booking.reservations.Reservation
import com.alg.boot.webapi.booking.reservations.ReservationRepository
import com.alg.boot.webapi.booking.reservations.data.ReservationCreateJson
import com.alg.boot.webapi.booking.reservations.data.ReservationJson
import com.alg.boot.webapi.booking.restaurants.Restaurant
import com.alg.boot.webapi.booking.restaurants.RestaurantRepository
import com.alg.boot.webapi.booking.turns.TurnRepository
import com.alg.boot.webapi.handlers.exceptions.NotFoundException
import com.alg.boot.webapi.handlers.exceptions.ServerErrorException
import org.modelmapper.ModelMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ReservationData(
    private val reservationRepository: ReservationRepository,
    private val restaurantRepository: RestaurantRepository,
    private val turnRepository: TurnRepository) : ReservationService {

    companion object {
        private val modelMapper: ModelMapper = ModelMapper()
        private val log = LoggerFactory.getLogger(ReservationData::class.java)
    }

    override fun getReservation(id: Long): ReservationJson {
        val reservation = reservationRepository.findById(id)
        return modelMapper.map(reservation, ReservationJson::class.java)
    }

    override fun createReservation(reservation: ReservationCreateJson): String {
        val turn = reservation.turnId?.let {
            turnRepository.findById(it)
                .orElseThrow { NotFoundException("DATA_404", "Turn with id ${reservation.turnId} not found") }
        }
        val restaurant = reservation.restaurantId?.let {
            restaurantRepository.findById(it)
                .orElseThrow { NotFoundException("DATA_404", "Restaurant with id ${reservation.restaurantId} not found") }
        }
        val turnName = turn?.name
        val restaurantId = restaurant?.id
        if (turnName == null || restaurantId == null) {
            throw ServerErrorException("DATA_500", "Turn or restaurant not found")
        }
        if(reservationRepository.findByTurnAndRestaurantId(turnName, restaurantId).isPresent) {
            throw ServerErrorException("DATA_409", "Reservation already exists")
        }
        val reservationEntity = Reservation()
        val locator = getLocator(restaurant, reservation)
        reservationEntity.locator = locator
        reservationEntity.person = reservation.person
        reservationEntity.date = reservation.date
        reservationEntity.turn = turn.name
        reservationEntity.restaurant = restaurant
        try {
            reservationRepository.save(reservationEntity)
        } catch (e: Exception) {
            log.error("Error while saving reservation: ${e.message}")
            throw ServerErrorException("DATA_500", "Error while saving reservation")
        }
        return locator
    }

    private fun getLocator(restaurant: Restaurant?, reservation: ReservationCreateJson): String {
        return "${restaurant?.name}_${reservation.turnId}"
    }
}
