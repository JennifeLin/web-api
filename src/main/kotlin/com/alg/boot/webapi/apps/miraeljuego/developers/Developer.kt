package com.alg.boot.webapi.apps.miraeljuego.developers

import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.URL
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "DEVELOPERS")
class Developer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", unique = true, nullable = false, length = 64)
    @NotBlank
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "LOGO")
    @URL
    var logo: String? = null,

    @Column(name = "URL")
    @URL
    var url: String? = null,
): AuditableEntity<String>()
