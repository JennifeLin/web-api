package com.alg.boot.webapi.handlers.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class ServerErrorException : GeneralException {
    constructor(status: String?, message: String?) : super(
        status!!,
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        message
    ) {
    }
    constructor(status: String?, message: String?, error: Error?) : super(
        status!!, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(error) as List<Error>?
    ) {
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
