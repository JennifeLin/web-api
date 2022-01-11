package com.alg.boot.webapi.booking.v1

import com.alg.boot.webapi.booking.reservations.data.ReservationCreateJson
import com.alg.boot.webapi.booking.reservations.data.ReservationJson
import com.alg.boot.webapi.booking.reservations.services.ReservationService
import com.alg.boot.webapi.handlers.exceptions.GeneralException
import com.alg.boot.webapi.handlers.responses.GeneralResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
@RequestMapping("/api/v1/reservations")
class ReservationController(
    private val reservationService: ReservationService
) {
    @Throws(GeneralException::class)
    @GetMapping("/{id}")
    fun getReservation(@PathVariable id: Long): GeneralResponse<ReservationJson> {
        return GeneralResponse("Success", HttpStatus.OK.value(), "OK",
                reservationService.getReservation(id))
    }

    @Throws(GeneralException::class)
    @PostMapping
    fun create(@RequestBody @Valid reservationCreateJson: ReservationCreateJson): GeneralResponse<String> {
        return GeneralResponse("Success", HttpStatus.OK.value(), "OK",
            reservationService.createReservation(reservationCreateJson)
        )
    }
}
