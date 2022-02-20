package com.alg.boot.webapi.apps.shared.service

interface MappingMutableService<T> {
    fun to(data: Any, vararg input: Any): T
}
