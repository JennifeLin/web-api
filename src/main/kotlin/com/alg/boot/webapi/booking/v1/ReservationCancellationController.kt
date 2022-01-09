package com.alg.boot.webapi.booking.v1

import com.alg.boot.webapi.booking.reservations.services.ReservationCancellationService
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/reservations")
class ReservationCancellationController(
    private val reservationCancellationService: ReservationCancellationService
) {
    @Throws(GeneralException::class)
    @DeleteMapping
    fun cancel(@RequestParam locator: String): GeneralResponse<String> {
        return GeneralResponse("Success", HttpStatus.OK.value(), "OK",
            reservationCancellationService.cancelReservation(locator)
        )
    }
}
