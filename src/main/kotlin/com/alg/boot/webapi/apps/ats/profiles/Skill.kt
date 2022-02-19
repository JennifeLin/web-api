package com.alg.boot.webapi.apps.ats.profiles

import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.Range
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
): AuditableEntity<String>()
