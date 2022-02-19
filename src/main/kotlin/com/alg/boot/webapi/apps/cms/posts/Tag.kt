package com.alg.boot.webapi.apps.cms.posts

import com.alg.boot.webapi.apps.shared.AuditableEntity
import javax.persistence.*

@Entity
@Table(name = "TAGS", uniqueConstraints = [UniqueConstraint(columnNames = ["NAME", "SLUG_URI"])])
class Tag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "SLUG_URI", nullable = false)
    var slug: String? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    var name: String? = null,
): AuditableEntity<String>()
