package com.alg.boot.webapi.apps.content.galleries

import com.alg.boot.webapi.apps.shared.AuditableEntity
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "GALLERIES")
class Gallery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "TITLE", length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "gallery")
    var photos: List<Photo> = emptyList(),
): AuditableEntity<String>() {
    @PrePersist
    fun prePersistData() {
        this.slug = UUID.randomUUID().toString()
    }
}
