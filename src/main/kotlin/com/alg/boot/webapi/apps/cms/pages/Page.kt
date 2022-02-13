package com.alg.boot.webapi.apps.cms.pages

import com.alg.boot.webapi.enums.Status
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "pages")
class Page(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Column(name = "TITLE", nullable = true, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "CONTENT", columnDefinition = "TEXT")
    var content: String? = null,

    @Column(name = "STATUS", length = 64)
    @Enumerated(EnumType.STRING)
    var status: Status = Status.DRAFT,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
