package com.alg.boot.webapi.apps.ats.profiles

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
@Table(name = "SCHOOLS")
class School(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
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

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
