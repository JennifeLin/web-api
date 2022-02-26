package com.alg.boot.webapi.apps.ats.companies

import com.alg.boot.webapi.apps.ats.jobs.Job
import com.alg.boot.webapi.apps.content.galleries.Photo
import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.URL
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "COMPANIES")
class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, unique = true, length = 160)
    @NotBlank
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "WEBSITE_URL")
    @URL
    var website: String? = null,

    @Column(name = "LOGO_URL")
    @URL
    var logo: String? = null,

    @Column(name = "FOUNDED_DATE")
    @PastOrPresent
    var foundedAt: LocalDate? = null,

    @OneToOne
    var location: Location? = null,

    @ElementCollection
    @CollectionTable(name = "COMPANIES_BENEFITS", joinColumns = [JoinColumn(name = "COMPANY_ID")])
    var benefits: List<String>? = emptyList(),

    @Column(name = "COMPANY_SIZE", length = 64)
    var size: String? = null,

    @Column(name = "INDUSTRY", length = 160)
    var industry: String? = null,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        joinColumns = [JoinColumn(name = "COMPANY_ID")],
        inverseJoinColumns = [JoinColumn(name = "PHOTO_ID")]
    )
    var photos: MutableList<Photo>? = null,

    @Column(name = "MISSION", length = 600, columnDefinition = "TEXT")
    var mission: String? = null,

    @OneToMany(mappedBy = "company")
    var jobs: MutableSet<Job>? = null
): AuditableEntity<String>()
