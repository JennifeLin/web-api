package com.alg.boot.webapi.apps.security.roles

import com.alg.boot.webapi.apps.shared.AuditableEntity
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "ROLES")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "NAME", unique = true, nullable = false, updatable = false)
    @NotBlank
    var name: String? = null,
)
