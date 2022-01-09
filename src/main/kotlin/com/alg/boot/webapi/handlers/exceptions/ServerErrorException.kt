package com.alg.boot.webapi.handlers.exceptions

import org.springframework.http.HttpStatus

class ServerErrorException : GeneralException {
    constructor(status: String?, message: String?) : super(
        status!!,
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        message
    )
    constructor(status: String?, message: String?, error: Error) : super(
        status!!, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, listOf(error)
    )

    companion object {
        private const val serialVersionUID = 1L
    }
}
