package com.alg.boot.webapi.apps.ats.companies

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "LOCATIONS")
class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "CITY", nullable = false, length = 160)
    @NotBlank
    var city: String? = null,

    @Column(name = "STREET", length = 400)
    var street: String? = null,

    @Column(name = "STATE", length = 160)
    var state: String? = null,

    @Column(name = "POSTAL_CODE", length = 10)
    var zip: String? = null,

    @Column(name = "COUNTRY", length = 160)
    var country: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
