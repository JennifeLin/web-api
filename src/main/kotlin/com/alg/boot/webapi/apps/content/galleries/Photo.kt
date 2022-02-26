package com.alg.boot.webapi.apps.content.galleries

import com.alg.boot.webapi.apps.miraeljuego.consoles.Console
import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.URL
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "PHOTOS")
class Photo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "URL")
    @URL
    @NotBlank
    var url: String? = null,

    @Column(name = "ALT_TEXT", length = 64)
    var alternativeText: String? = null,

    @Column(name = "NUMBER_OF_VIEWS")
    @PositiveOrZero
    var views: Int = 0,

    @Column(name = "NUMBER_OF_LIKES")
    @PositiveOrZero
    var likes: Int = 0,

    @Column(name = "NUMBER_OF_COMMENTS")
    @PositiveOrZero
    var comments: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GALLERY_ID", nullable = true)
    var gallery: Gallery? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSOLE_ID", nullable = true)
    var console: Console? = null,
): AuditableEntity<String>()
