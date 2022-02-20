package com.alg.boot.webapi.handlers.responses

import java.io.Serializable
import java.time.Instant

open class GeneralResponse<T> : Serializable {
    var code: Int = 0
    var message: String? = null
    var status: String? = null
    var data: T? = null
    val timestamp: Instant = Instant.now()

    constructor(status: String?, code: Int, message: String?, data: T?) {
        this.status = status
        this.code = code
        this.message = message
        this.data = data
    }
    constructor(status: String?, code: Int, message: String?) {
        this.status = status
        this.code = code
        this.message = message
    }
    constructor(code: Int, data: T?) {
        this.code = code
        this.data = data
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
