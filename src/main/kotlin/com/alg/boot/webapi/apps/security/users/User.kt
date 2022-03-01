package com.alg.boot.webapi.apps.security.users

import com.alg.boot.webapi.apps.security.roles.Role
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "USERS")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "USERNAME", unique = true, nullable = false, updatable = false)
    @NotBlank
    var username: String? = null,

    @Column(name = "PASSWORD", nullable = false)
    @NotBlank
    var password: String? = null,

    @Column(name = "SALT", nullable = false, updatable = false)
    @NotBlank
    var salt: String? = null,

    @Column(name = "ENABLED")
    var isEnabled: Boolean? = null,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(name = "USERS_ROLES",
        joinColumns = [JoinColumn(name = "USER_ID")],
        inverseJoinColumns = [JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")])
    var roles: MutableSet<Role>? = null
)
