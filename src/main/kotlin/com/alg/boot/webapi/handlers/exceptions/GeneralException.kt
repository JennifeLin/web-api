package com.alg.boot.webapi.handlers.exceptions

open class GeneralException : Exception {
    val status: String
    val code: Int
    private val errors: MutableList<Error> = ArrayList()

    constructor(status: String, code: Int, message: String?) : super(message) {
        this.status = status
        this.code = code
    }

    constructor(status: String, code: Int, message: String?, errors: List<Error>?) : super(message) {
        this.status = status
        this.code = code
        this.errors.addAll(errors!!)
    }

    fun getErrors(): List<Error> {
        return errors
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
