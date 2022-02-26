package com.alg.boot.webapi.apps.miraeljuego.games

import com.alg.boot.webapi.apps.cms.posts.Category
import com.alg.boot.webapi.apps.cms.posts.Tag
import com.alg.boot.webapi.apps.content.galleries.Gallery
import com.alg.boot.webapi.apps.content.galleries.Video
import com.alg.boot.webapi.apps.content.news.Article
import com.alg.boot.webapi.apps.miraeljuego.consoles.Console
import com.alg.boot.webapi.apps.miraeljuego.developers.Developer
import com.alg.boot.webapi.apps.miraeljuego.genres.Genre
import com.alg.boot.webapi.apps.miraeljuego.publishers.Publisher
import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.validator.constraints.Range
import org.hibernate.validator.constraints.URL
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
@Table(name = "GAMES")
class Game(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "NAME", unique = true, nullable = false, length = 64)
    @NotBlank
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "RATING")
    @Positive
    @Range(min = 0, max = 10)
    var rating: Int = 0,

    @Column(name = "COVER_URL")
    @URL
    var cover: String? = null,

    @Column(name = "RELEASE_DATE")
    var releaseDate: LocalDate? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "GAME_ID")
    var genres: MutableList<Genre>? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "GAME_ID")
    var news: MutableList<Article>? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "GAME_ID")
    var galleries: MutableList<Gallery>? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "GAME_ID")
    var videos: MutableList<Video>? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "GAME_ID")
    var consoles: MutableList<Console>? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "PUBLISHER_ID", nullable = true)
    var publisher: Publisher? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "DEVELOPER_ID", nullable = true)
    var developer: Developer? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "CATEGORY_ID", nullable = true)
    var category: Category? = null,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        joinColumns = [JoinColumn(name = "GAME_ID")],
        inverseJoinColumns = [JoinColumn(name = "TAG_ID")]
    )
    var tags: MutableList<Tag>? = null,
): AuditableEntity<String>()
