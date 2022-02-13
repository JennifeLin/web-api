package com.alg.boot.webapi.apps.characters

import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
@Table(name = "animes")
class Anime(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "SUMMARY", columnDefinition = "TEXT")
    var summary: String? = null,

    @Column(name = "SEASONS_NUMBER")
    @Positive
    var seasons: Int? = null,

    @Column(name = "EPISODES_NUMBER")
    @Positive
    var episodes: Int? = null,

    @Column(name = "COVER_URL")
    @URL
    var cover: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
