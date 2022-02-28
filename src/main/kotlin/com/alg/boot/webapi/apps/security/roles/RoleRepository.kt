package com.alg.boot.webapi.apps.security.roles

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: String): Optional<Role>
    fun existsByName(name: String): Boolean
}
