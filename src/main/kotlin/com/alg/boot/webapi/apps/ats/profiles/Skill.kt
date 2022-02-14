package com.alg.boot.webapi.apps.ats.profiles

import org.hibernate.validator.constraints.Range
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
@Table(name = "SKILLS")
class Skill(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "LEVEL")
    @Positive
    @Range(min = 1, max = 10)
    var level: Int? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
