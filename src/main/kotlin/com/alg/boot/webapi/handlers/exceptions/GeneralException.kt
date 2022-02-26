package com.alg.boot.webapi.handlers.exceptions

import org.springframework.http.HttpStatus

open class GeneralException : RuntimeException {
    val status: HttpStatus
    private val code: Int
    private val errors: MutableList<Error> = ArrayList()

    fun getErrors(): MutableList<Error> {
        return this.errors
    }

    fun getCode(): Int {
        return this.code
    }

    constructor(httpStatus: HttpStatus, message: String?) : super(message) {
        this.status = httpStatus
        this.code = httpStatus.value()
    }

    constructor(httpStatus: HttpStatus, message: String?, errors: List<Error>?) : super(message) {
        this.status = httpStatus
        this.code = httpStatus.value()
        this.errors.addAll(errors!!)
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
