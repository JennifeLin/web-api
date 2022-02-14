package com.alg.boot.webapi.apps.cms.sites

import org.hibernate.validator.constraints.Range
import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.Positive

@Entity
@Table(name = "SEO_CONTENT")
class Seo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "TITLE", length = 160)
    var title: String,

    @Column(name = "DESCRIPTION")
    var description: String? = null,

    @Column(name = "SUBJECT")
    var subject: String? = null,

    @Column(name = "CANONICAL_URL")
    @URL
    var canonicalUrl: String? = null,

    @Column(name = "ROBOTS")
    var robots: String? = null,

    @Column(name = "CLASSIFICATION")
    var classification: String? = null,

    @Column(name = "IMAGE_URL")
    @URL
    var image: String? = null,

    @Column(name = "AUTHOR")
    var author: String? = null,

    @Column(name = "COPYRIGHT")
    var copyright: String? = null,

    @Column(name = "RATING")
    @Positive
    @Range(min = 0, max = 5)
    var rating: Int = 0,

    @Column(name = "FB_TITLE", length = 160)
    var facebookTitle: String? = null,

    @Column(name = "FB_DESCRIPTION")
    var facebookDescription: String? = null,

    @Column(name = "FB_IMAGE_URL")
    @URL
    var facebookImage: String? = null,

    @Column(name = "TW_TITLE", length = 160)
    var twitterTitle: String? = null,

    @Column(name = "TW_DESCRIPTION")
    var twitterDescription: String? = null,

    @Column(name = "TW_IMAGE_URL")
    @URL
    var twitterImage: String? = null,

    @Column(name = "TW_HASHTAG")
    var twitterHashtag: String? = null,

    @Column(name = "TW_AUTHOR")
    var twitterAuthor: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
