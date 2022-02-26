package com.alg.boot.webapi.apps.cms.pages

import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.arthurolg.enums.Status
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "PAGES")
class Page(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "SLUG_URI", nullable = false, unique = true)
    var slug: String? = null,

    @Column(name = "TITLE", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "CONTENT")
    @Lob
    var content: String? = null,

    @Column(name = "STATUS", length = 64)
    @Enumerated(EnumType.STRING)
    var status: Status = Status.DRAFT,
): AuditableEntity<String>() {
    @PrePersist
    fun prePersistData() {
        this.slug = UUID.randomUUID().toString()
    }
}
