package com.alg.boot.webapi.apps.ats.jobs

import com.alg.boot.webapi.apps.ats.profiles.Profile
import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.arthurolg.enums.JobStatus
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "JOBS_CANDIDATES")
class Candidate(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    @NotNull
    var job: Job? = null,

    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    @NotNull
    var profile: Profile? = null,

    @Column(name = "STATUS")
    var status: JobStatus = JobStatus.NEW,

    @Column(name = "NOTES", length = 100, columnDefinition = "TEXT")
    var notes: String? = null,
): AuditableEntity<String>()
