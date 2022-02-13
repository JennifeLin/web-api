package com.alg.boot.webapi.apps.ats.profiles

import com.alg.boot.webapi.enums.Currency
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "works")
class Work(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "ACTIVITIES", nullable = false, length = 1000)
    @Lob
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
    @CollectionTable(name = "works_benefits", joinColumns = [JoinColumn(name = "work_id")])
    var benefits: List<String> = emptyList(),

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
