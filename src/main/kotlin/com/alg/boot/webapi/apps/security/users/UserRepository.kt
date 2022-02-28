package com.alg.boot.webapi.apps.security.users

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsernameAndIsEnabledIsTrue(username: String): Optional<User>
    fun existsByUsernameAndIsEnabledIsTrue(username: String): Boolean
}
