package com.alg.boot.webapi.apps.booking.reservations.services

import com.alg.boot.webapi.apps.booking.reservations.data.ReservationCreateJson
import com.alg.boot.webapi.apps.booking.reservations.data.ReservationJson
import com.alg.boot.webapi.handlers.exceptions.GeneralException

interface ReservationService {
    @Throws(GeneralException::class)
    fun getReservation(id: Long): ReservationJson
    @Throws(GeneralException::class)
    fun createReservation(reservation: ReservationCreateJson): String
}
