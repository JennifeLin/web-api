package com.alg.boot.webapi.apps.booking.reservations.services

import com.alg.boot.webapi.apps.booking.reservations.ReservationRepository
import com.alg.boot.webapi.handlers.exceptions.NotFoundException
import com.alg.boot.webapi.handlers.exceptions.ServerErrorException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ReservationCancellationData(private val reservationRepository: ReservationRepository) :
    ReservationCancellationService {

    companion object {
        private val log = LoggerFactory.getLogger(ReservationData::class.java)
    }

    override fun cancelReservation(locator: String): String {
        reservationRepository.findByLocator(locator)
            .orElseThrow { NotFoundException("Reservation with locator $locator not found") }
        try {
            reservationRepository.deleteByLocator(locator)
        } catch (e: Exception) {
            log.error("Error while deleting reservation: ${e.message}")
            throw ServerErrorException("Error while deleting reservation")
        }
        return "LOCATOR_${locator}_CANCELED"
    }
}
