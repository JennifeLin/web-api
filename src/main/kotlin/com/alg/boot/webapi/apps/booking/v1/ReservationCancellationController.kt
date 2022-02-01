package com.alg.boot.webapi.apps.booking.v1

import com.alg.boot.webapi.apps.booking.reservations.services.ReservationCancellationService
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
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
