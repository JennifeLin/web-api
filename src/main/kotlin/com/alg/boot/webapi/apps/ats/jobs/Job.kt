package com.alg.boot.webapi.apps.ats.jobs

import com.alg.boot.webapi.apps.ats.companies.Company
import com.alg.boot.webapi.apps.ats.companies.Location
import com.alg.boot.webapi.enums.Currency
import com.alg.boot.webapi.enums.TypeJob
import org.hibernate.validator.constraints.Range
import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
@Table(name = "JOBS", uniqueConstraints = [UniqueConstraint(columnNames = ["SLUG_URI"])])
class Job(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "TITLE", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "TYPE_JOB", length = 64)
    @Enumerated(EnumType.STRING)
    var type: TypeJob = TypeJob.FULL_TIME,

    @Column(name = "IS_REMOTE")
    var isRemote: Boolean = false,

    @Column(name = "IS_PUBLISHED")
    var isPublised: Boolean = false,

    @Column(name = "IS_PUBLISHED_AT")
    var publishedAt: LocalDate? = null,

    @Column(name = "IS_CLOSED")
    var isClosed: Boolean = false,

    @Column(name = "HIRED_NUMBER")
    @Range(min = 1, max = 100)
    @Positive
    var hiredNumber: Int? = null,

    @OneToOne
    var location: Location? = null,

    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    var company: Company? = null,

    @Column(name = "URL")
    @URL
    var url: String? = null,

    @ElementCollection
    @CollectionTable(name = "JOBS_TAGS", joinColumns = [JoinColumn(name = "JOB_ID")])
    var tags: List<String> = emptyList(),

    @Column(name = "SALARY", length = 160)
    var salary: String? = null,

    @Column(name = "CURRENCY", length = 4)
    var currency: Currency = Currency.MXN,

    @ElementCollection
    @CollectionTable(name = "JOBS_SKILLS", joinColumns = [JoinColumn(name = "JOB_ID")])
    var skills: List<String> = emptyList(),

    @ElementCollection
    @CollectionTable(name = "JOBS_BENEFITS", joinColumns = [JoinColumn(name = "JOB_ID")])
    var benefits: List<String> = emptyList(),

    @Column(name = "RESPONSIBILITIES", length = 1000, columnDefinition = "TEXT")
    var responsibilities: String? = null,

    @Column(name = "COVER_URL")
    @URL
    var cover: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
