package com.alg.boot.webapi.apps.cms.snippets

import com.alg.boot.webapi.enums.ProgrammingLanguage
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "snippets")
class Snippet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "TITLE", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "LANGUAGE")
    @Enumerated(EnumType.STRING)
    var language: ProgrammingLanguage? = null,

    @Column(name = "CODE", nullable = false, columnDefinition = "TEXT")
    @NotBlank
    var code: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "TECHNOLOGY_ID", nullable = false)
    var technology: Technology? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
