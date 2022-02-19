package com.alg.boot.webapi.apps.cms.snippets

import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.alg.boot.webapi.enums.TypeTechnology
import org.hibernate.validator.constraints.URL
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "TECHNOLOGIES")
class Technology(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, unique = true, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "DESCRIPTION", nullable = false, length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "LOGO_URL")
    @URL
    var logo: String? = null,

    @Column(name = "TECHNOLOGY_URL")
    @URL
    var url: String? = null,

    @Column(name = "TECHNOLOGY")
    @Enumerated(EnumType.STRING)
    var technology: TypeTechnology? = null,
): AuditableEntity<String>()
