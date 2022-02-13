package com.alg.boot.webapi.apps.ats.jobs

import com.alg.boot.webapi.apps.ats.profiles.Profile
import com.alg.boot.webapi.enums.JobStatus
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "jobs_candidates")
class Candidate(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

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

    @Column(name = "NOTES", length = 100)
    @Lob
    var notes: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
