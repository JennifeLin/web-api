package com.alg.boot.webapi.apps.booking.reservations.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
class ReservationCreateJson(
    @JsonProperty("turnId")
    val turnId: Long? = null,

    @JsonProperty("restaurantId")
    val restaurantId: Long? = null,

    @JsonProperty("person")
    val person: Long? = null,

    @JsonProperty("date")
    val date: Date? = null
)
