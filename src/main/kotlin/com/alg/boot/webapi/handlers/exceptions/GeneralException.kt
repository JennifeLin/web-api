package com.alg.boot.webapi.handlers.exceptions

import org.springframework.http.HttpStatus

open class GeneralException : RuntimeException {
    private val status: String
    private val code: Int
    private val errors: MutableList<Error> = ArrayList()

    constructor(httpStatus: HttpStatus, message: String?) : super(message) {
        this.status = httpStatus.name
        this.code = httpStatus.value()
    }

    constructor(httpStatus: HttpStatus, message: String?, errors: List<Error>?) : super(message) {
        this.status = httpStatus.name
        this.code = httpStatus.value()
        this.errors.addAll(errors!!)
    }

    constructor(status: String, code: Int, message: String?) : super(message) {
        this.status = status
        this.code = code
    }

    constructor(status: String, code: Int, message: String?, errors: List<Error>?) : super(message) {
        this.status = status
        this.code = code
        this.errors.addAll(errors!!)
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
