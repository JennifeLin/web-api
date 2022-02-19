package com.alg.boot.webapi.apps.cms.sites

import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.URL
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "SOCIAL_NETWORKS")
class SocialNetwork(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "URL")
    @URL
    @NotBlank
    var url: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    val description: String? = null,
): AuditableEntity<String>()
