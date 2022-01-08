package com.alg.boot.webapi.booking.reservations.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
class ReservationCreateJson {
    @JsonProperty("id")
    var id: Long? = null

    @JsonProperty("locator")
    var locator: String? = null

    @JsonProperty("turn")
    var turn: String? = null

    @JsonProperty("person")
    var person: Long? = null

    @JsonProperty("date")
    var date: Date? = null

    @JsonProperty("restaurantId")
    var restaurantId: Long? = null
}