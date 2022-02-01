package com.alg.boot.webapi.apps.booking.reservations.services

import com.alg.boot.webapi.handlers.exceptions.GeneralException

interface ReservationCancellationService {
    @Throws(GeneralException::class)
    fun cancelReservation(locator: String): String
}
