package com.alg.boot.webapi.apps.content.ads

import com.alg.boot.webapi.apps.shared.AuditableEntity
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "ADS")
class Advertisement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "CODE", nullable = false)
    @NotBlank
    @Lob
    var code: String? = null,
): AuditableEntity<String>()
