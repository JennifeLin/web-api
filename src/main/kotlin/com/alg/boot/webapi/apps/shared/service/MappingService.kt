package com.alg.boot.webapi.apps.shared.service

interface MappingService<T> {
    fun to(data: Any): T
}
