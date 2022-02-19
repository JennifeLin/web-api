package com.alg.boot.webapi.apps.characters

import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.URL
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
@Table(name = "ANIMES")
class Anime(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, unique = true, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "SUMMARY", length = 600, columnDefinition = "TEXT")
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
): AuditableEntity<String>()
