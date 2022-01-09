package com.alg.boot.webapi.handlers.exceptions

import java.io.Serializable

open class Error protected constructor() : Serializable {
    var name: String? = null
    var value: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}
