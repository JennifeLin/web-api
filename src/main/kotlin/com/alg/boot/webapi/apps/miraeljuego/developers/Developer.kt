package com.alg.boot.webapi.apps.miraeljuego.developers

import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "developers")
class Developer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 64)
    @NotBlank
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 600)
    @Lob
    var description: String? = null,

    @Column(name = "LOGO")
    @URL
    var logo: String? = null,

    @Column(name = "URL")
    @URL
    var url: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
