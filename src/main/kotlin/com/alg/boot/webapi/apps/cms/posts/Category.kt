package com.alg.boot.webapi.apps.cms.posts

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "CATEGORIES", uniqueConstraints = [UniqueConstraint(columnNames = ["NAME", "SLUG_URI"])])
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160, unique = true)
    var name: String? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
