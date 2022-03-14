package com.alg.boot.webapi.apps.security.roles

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: String): Optional<Role>
    fun existsByName(name: String): Boolean
}
