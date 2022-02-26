package com.alg.boot.webapi.apps.miraeljuego.publishers

import com.alg.boot.webapi.apps.miraeljuego.developers.Developer
import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.URL
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "PUBLISHERS")
class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "NAME", unique = true, nullable = false, length = 64)
    @NotBlank
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
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
): AuditableEntity<String>()
