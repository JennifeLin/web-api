package com.alg.boot.webapi.apps.cms.sites

import com.alg.boot.webapi.apps.shared.AuditableEntity
import javax.persistence.*

@Entity
@Table(name = "SETTINGS")
class Setting(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "PROPERTY_NAME", nullable = false)
    var property: String? = null,

    @Column(name = "PROPERTY_TYPE", nullable = false)
    val type: String? = null,

    @Column(name = "PROPERTY_VALUE")
    @Lob
    var value: String? = null,
): AuditableEntity<String>()
