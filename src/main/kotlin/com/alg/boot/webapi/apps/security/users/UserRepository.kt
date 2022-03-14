package com.alg.boot.webapi.apps.security.users

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): Optional<User>
    fun findByUsernameAndIsEnabledIsTrue(username: String): Optional<User>
    fun existsByUsernameAndIsEnabledIsTrue(username: String): Boolean
    fun existsByUsername(username: String): Boolean
}
