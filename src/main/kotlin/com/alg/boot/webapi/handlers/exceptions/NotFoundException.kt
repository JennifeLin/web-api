package com.alg.boot.webapi.handlers.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException : GeneralException {
    constructor(message: String) : super(
        HttpStatus.NOT_FOUND,
        message
    )
    constructor(message: String?, error: Error) : super(
        HttpStatus.NOT_FOUND,
        message,
        listOf(error)
    )

    companion object {
        private const val serialVersionUID = 1L
    }
}
