package com.alg.boot.webapi.handlers.responses

import java.io.Serializable

open class GeneralResponse<T> : Serializable {
    var status: String? = null
    var code: Int = 0
    var message: String? = null
    var data: T? = null

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

    companion object {
        private const val serialVersionUID = 1L
    }
}
