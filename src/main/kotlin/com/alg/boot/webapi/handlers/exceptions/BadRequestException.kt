package com.alg.boot.webapi.handlers.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException : GeneralException {
    constructor(message: String) : super(
        HttpStatus.BAD_REQUEST,
        message
    )
    constructor(message: String?, error: Error) : super(
        HttpStatus.BAD_REQUEST,
        message,
        listOf(error)
    )

    companion object {
        private const val serialVersionUID = 1L
    }
}
