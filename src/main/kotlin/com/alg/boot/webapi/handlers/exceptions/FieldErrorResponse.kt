package com.alg.boot.webapi.handlers.exceptions

data class FieldErrorResponse(
    var `field`: String? = null,
    var errorCode: String? = null
)
