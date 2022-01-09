package com.alg.boot.webapi.booking.turns.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class TurnJson(
    @JsonProperty("id")
    var id: Long? = null,

    @JsonProperty("name")
    var name: String? = null
)
