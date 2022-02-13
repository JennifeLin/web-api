package com.alg.boot.webapi.apps.miraeljuego.publishers

import com.alg.boot.webapi.apps.miraeljuego.developers.Developer
import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "publishers")
class Publisher(
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

    @Column(name = "COUNTRY_NAME", length = 64)
    var country: String? = null,

    @Column(name = "FOUNDATION_DATE")
    @PastOrPresent
    var foundationDate: LocalDate? = null,

    @Column(name = "WEBSITE_URL")
    @URL
    var website: String? = null,

    @Column(name = "LOGO_URL")
    @URL
    var logo: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "DEVELOPER_ID", nullable = false)
    var developer: Developer? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
