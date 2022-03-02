package com.alg.boot.webapi.apps.content.galleries

import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.arthurolg.utils.StringUtil
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "GALLERIES")
class Gallery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "TITLE", length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "gallery")
    var photos: MutableList<Photo>? = null,
): AuditableEntity<String>() {
    @PrePersist
    fun prePersistData() {
        this.slug = StringUtil.slugURI(this.title)
    }
}
