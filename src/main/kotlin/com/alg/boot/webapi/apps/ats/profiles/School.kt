package com.alg.boot.webapi.apps.ats.profiles

import com.alg.boot.webapi.apps.shared.AuditableEntity
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
@Table(name = "SCHOOLS")
class School(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "INSTITUTION_NAME", nullable = false, length = 160)
    @NotBlank
    var institution: String? = null,

    @Column(name = "LEVEL", length = 160)
    var level: String? = null,

    @Column(name = "YEAR_START")
    @Positive
    var yearStart: Int? = null,

    @Column(name = "IS_ACTUAL")
    var isActual: Boolean? = null,

    @Column(name = "YEAR_END")
    @Positive
    var yearEnd: Int? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFILE_ID", nullable = false)
    var profile: Profile? = null
): AuditableEntity<String>()
