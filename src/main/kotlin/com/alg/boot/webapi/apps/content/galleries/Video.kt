package com.alg.boot.webapi.apps.content.galleries

import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "videos")
class Video(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "URL")
    @URL
    @NotBlank
    var url: String? = null,

    @Column(name = "TITLE", nullable = false, length = 64)
    @NotBlank
    var title: String? = null,

    @Column(name = "DESCRIPTION", length = 600)
    @Lob
    var description: String? = null,

    @Column(name = "DATE")
    var date: LocalDate? = null,

    @Column(name = "DURATION_IN_SECONDS")
    @PositiveOrZero
    var duration: Int = 0,

    @Column(name = "NUMBER_OF_VIEWS")
    @PositiveOrZero
    var views: Int = 0,

    @Column(name = "NUMBER_OF_LIKES")
    @PositiveOrZero
    var likes: Int = 0,

    @Column(name = "NUMBER_OF_COMMENTS")
    @PositiveOrZero
    var comments: Int = 0,

    @Column(name = "THUMBNAIL_URL")
    @URL
    var thumbnail: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
