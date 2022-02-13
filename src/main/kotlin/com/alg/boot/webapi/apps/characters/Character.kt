package com.alg.boot.webapi.apps.characters

import com.alg.boot.webapi.enums.Gender
import com.alg.boot.webapi.enums.TypeCharacter
import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "characters")
class Character(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "REAL_NAME", nullable = false, length = 160)
    @NotBlank
    var realName: String,

    @ElementCollection
    @CollectionTable(name = "CHARACTERS_KNOWN_ALIASES", joinColumns = [JoinColumn(name = "CHARACTER_ID")])
    var knownAliases: List<String> = mutableListOf(),

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "IS_SUPER_HUMAN")
    var isSuperHuman: Boolean = false,

    @Column(name = "TYPE_CHARACTER")
    @Enumerated(EnumType.STRING)
    var type: TypeCharacter? = null,

    @Column(name = "GENDER_CHARACTER")
    @Enumerated(EnumType.STRING)
    var gender: Gender = Gender.MAN,

    @ElementCollection
    @CollectionTable(name = "CHARACTERS_POWERS", joinColumns = [JoinColumn(name = "CHARACTER_ID")])
    var powers: List<String> = mutableListOf(),

    @ElementCollection
    @CollectionTable(name = "CHARACTERS_KNOWN_WEAKNESSES", joinColumns = [JoinColumn(name = "CHARACTER_ID")])
    var knownWeaknesses: List<String> = mutableListOf(),

    @ElementCollection
    @CollectionTable(name = "CHARACTERS_URLS", joinColumns = [JoinColumn(name = "CHARACTER_ID")])
    var urls: List<String> = mutableListOf(),

    @Column(name = "THUMBNAIL_URL")
    @URL
    var thumbnail: String? = null,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        joinColumns = [JoinColumn(name = "CHARACTER_ID")],
        inverseJoinColumns = [JoinColumn(name = "COMIC_ID")]
    )
    var comics: List<Comic> = mutableListOf(),

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        joinColumns = [JoinColumn(name = "CHARACTER_ID")],
        inverseJoinColumns = [JoinColumn(name = "ANIME_ID")]
    )
    var animes: List<Anime> = mutableListOf(),

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
