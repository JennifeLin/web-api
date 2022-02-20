package com.alg.boot.webapi.apps.cms.snippets

import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.arthurolg.enums.ProgrammingLanguage
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "SNIPPETS")
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

    @Column(name = "CODE", nullable = false)
    @NotBlank
    @Lob
    var code: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TECHNOLOGY_ID", nullable = false)
    var technology: Technology? = null,
): AuditableEntity<String>()
