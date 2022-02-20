package com.alg.boot.webapi.apps.cms.posts

import com.alg.boot.webapi.apps.shared.AuditableEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "CATEGORIES")
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "SLUG_URI", nullable = false, unique = true)
    var slug: String? = null,

    @Column(name = "NAME", nullable = false, length = 160, unique = true)
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,
): AuditableEntity<String>() {
    @PrePersist
    fun prePersistData() {
        this.slug = UUID.randomUUID().toString()
    }
}
