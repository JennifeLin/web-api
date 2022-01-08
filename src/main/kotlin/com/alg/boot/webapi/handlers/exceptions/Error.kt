package com.alg.boot.webapi.handlers.exceptions

import java.io.Serializable

class Error : Serializable {
    var name: String? = null
    var value: String? = null

    protected constructor() {}
    constructor(name: String?, value: String?) {
        this.name = name
        this.value = value
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
