package com.alg.boot.webapi.apps.booking.restaurants.data

import com.alg.boot.webapi.apps.booking.turns.data.TurnJson
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class RestaurantDetailJson(
    @JsonProperty("id")
    var id: Long? = null,

    @JsonProperty("name")
    var name: String? = null,

    @JsonProperty("address")
    var address: String? = null,

    @JsonProperty("description")
    var description: String? = null,

    @JsonProperty("image")
    var image: String? = null,

    @JsonProperty("turns")
    var turns: List<TurnJson> = emptyList()
)
