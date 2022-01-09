package com.alg.boot.webapi.booking.v1

import com.alg.boot.webapi.booking.reservations.data.ReservationCreateJson
import com.alg.boot.webapi.booking.reservations.services.ReservationService
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/reservations")
class ReservationController(
    private val reservationService: ReservationService
) {
    @Throws(GeneralException::class)
    @PostMapping
    fun create(@RequestBody @Valid reservationCreateJson: ReservationCreateJson): GeneralResponse<String> {
        return GeneralResponse("Success", HttpStatus.OK.value(), "OK",
            reservationService.createReservation(reservationCreateJson)
        )
    }
}
