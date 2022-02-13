package com.alg.boot.webapi.apps.content.ads

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "ads")
class Advertisement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "CODE", nullable = false, columnDefinition = "TEXT")
    @NotBlank
    var code: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
