package com.alg.boot.webapi.apps.content.news

import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "articles")
class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "TITLE", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Column(name = "CONTENT", columnDefinition = "TEXT")
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

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
