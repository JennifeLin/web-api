package com.alg.boot.webapi.handlers.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class ServerErrorException : GeneralException {
    constructor(message: String?) : super(
        HttpStatus.INTERNAL_SERVER_ERROR,
        message
    )
    constructor(message: String?, error: Error) : super(
        HttpStatus.INTERNAL_SERVER_ERROR,
        message,
        listOf(error)
    )

    companion object {
        private const val serialVersionUID = 1L
    }
}
