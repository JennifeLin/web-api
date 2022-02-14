package com.alg.boot.webapi.apps.cms.posts

import com.alg.boot.webapi.apps.cms.sites.Seo
import com.alg.boot.webapi.apps.cms.sites.Site
import com.alg.boot.webapi.apps.content.comments.Comment
import com.alg.boot.webapi.enums.Status
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "POSTS", uniqueConstraints = [UniqueConstraint(columnNames = ["TITLE", "SLUG_URI"])])
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Column(name = "TITLE", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "SUMMARY", length = 600, columnDefinition = "TEXT")
    var summary: String? = null,

    @Column(name = "CONTENT")
    @Lob
    var content: String? = null,

    @Column(name = "COVER_URL")
    @URL
    var cover: String? = null,

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    var status: Status = Status.DRAFT,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = true)
    var category: Category? = null,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        joinColumns = [JoinColumn(name = "POST_ID")],
        inverseJoinColumns = [JoinColumn(name = "TAG_ID")]
    )
    var tags: MutableList<Tag> = mutableListOf(),

    @Column(name = "PUBLISHED_AT")
    var publishedAt: LocalDate,

    @Column(name = "IS_PUBLISHED")
    var isPublished: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SITE_ID", nullable = false)
    var site: Site,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "SEO_ID", nullable = true)
    var seo: Seo? = null,

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "POST_ID")
    var comments: List<Comment> = emptyList(),

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
