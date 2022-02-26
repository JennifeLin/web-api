package com.alg.boot.webapi.apps.ats.profiles

import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.arthurolg.enums.Currency
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "WORKS")
class Work(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "ACTIVITIES", nullable = false, length = 1000, columnDefinition = "TEXT")
    var activities: String? = null,

    @Column(name = "COMPANY", length = 160)
    var companyName: String? = null,

    @Column(name = "COMPANY_ADDRESS")
    var companyAddress: String? = null,

    @Column(name = "START_DATE")
    var startDate: LocalDate? = null,

    @Column(name = "END_DATE")
    var endDate: LocalDate? = null,

    @Column(name = "IS_ACTUAL")
    var isActual: Boolean? = null,

    @Column(name = "SALARY", length = 160)
    var salary: String? = null,

    @Column(name = "CURRENCY", length = 4)
    var currency: Currency = Currency.MXN,

    @ElementCollection
    @CollectionTable(name = "WORKS_BENEFITS", joinColumns = [JoinColumn(name = "WORK_ID")])
    var benefits: List<String>? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFILE_ID", nullable = false)
    var profile: Profile? = null
): AuditableEntity<String>()
