package com.alg.boot.webapi.apps.cms.sites

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "settings")
class Setting(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "PROPERTY_NAME", unique = true, nullable = false)
    var property: String? = null,

    @Column(name = "PROPERTY_TYPE", nullable = false)
    val type: String? = null,

    @Column(name = "PROPERTY_VALUE", columnDefinition = "TEXT")
    var value: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
