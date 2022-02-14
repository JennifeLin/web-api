package com.alg.boot.webapi.apps.cms.sites

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
@Table(name = "MONITORS")
class Monitor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @OneToOne
    @NotNull
    var site: Site? = null,

    @Column(name = "FREQUENCY_IN_SEC")
    @Positive
    var frequency: Int? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
