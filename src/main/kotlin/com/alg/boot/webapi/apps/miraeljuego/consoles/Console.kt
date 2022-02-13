package com.alg.boot.webapi.apps.miraeljuego.consoles

import com.alg.boot.webapi.apps.content.galleries.Photo
import org.hibernate.validator.constraints.Range
import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PastOrPresent
import javax.validation.constraints.Positive

@Entity
@Table(name = "consoles")
class Console(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 64)
    @NotBlank
    var name: String? = null,

    @Column(name = "RELEASE_DATE")
    @PastOrPresent
    var releaseDate: LocalDate? = null,

    @Column(name = "DEVELOPER", length = 64)
    var developer: String? = null,

    @Column(name = "LOGO")
    @URL
    var logo: String? = null,

    @Column(name = "DESCRIPTION", length = 600)
    @Lob
    var description: String? = null,

    @Column(name = "PRICE")
    @Positive
    var price: Double? = null,

    @Column(name = "RATING")
    @Positive
    @Range(min = 0, max = 5)
    var rating: Int = 0,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "console")
    var photos: List<Photo> = emptyList(),

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
