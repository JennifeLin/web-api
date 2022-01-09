package com.alg.boot.webapi.handlers.exceptions

import org.springframework.http.HttpStatus

class NotFoundException : GeneralException {
    constructor(status: String?, message: String?) : super(
        status!!,
        HttpStatus.NOT_FOUND.value(),
        message
    )
    constructor(status: String?, message: String?, error: Error) : super(
        status!!, HttpStatus.NOT_FOUND.value(), message, listOf(error)
    )

    companion object {
        private const val serialVersionUID = 1L
    }
}
