package com.alg.boot.webapi.handlers.exceptions

import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZoneId

open class ErrorResponse(
    var code: Int? = null,
    var message: String? = null,
    var exception: String? = null,
    var fieldErrors: List<FieldErrorResponse> = emptyList(),
    val timestamp: LocalDateTime = LocalDateTime.now(ZoneId.of("America/Cancun"))
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }
}
