package com.alg.boot.webapi.apps.content.news

import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.URL
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "ARTICLES")
class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "TITLE", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "SLUG_URI", nullable = false, unique = true)
    var slug: String? = null,

    @Column(name = "CONTENT")
    @Lob
    var content: String? = null,

    @Column(name = "COVER_URL")
    @URL
    var cover: String? = null,

    @Column(name = "NUMBER_OF_VIEWS")
    @PositiveOrZero
    var views: Int = 0,

    @Column(name = "NUMBER_OF_COMMENTS")
    @PositiveOrZero
    var comments: Int = 0,
): AuditableEntity<String>() {
    @PrePersist
    fun prePersistData() {
        this.slug = UUID.randomUUID().toString()
    }
}
