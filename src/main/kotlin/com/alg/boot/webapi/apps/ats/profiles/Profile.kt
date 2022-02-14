package com.alg.boot.webapi.apps.ats.profiles

import com.alg.boot.webapi.apps.ats.companies.Location
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "PROFILES", uniqueConstraints = [UniqueConstraint(columnNames = ["SLUG_URI"])])
class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", nullable = false, length = 100)
    var firstName: String? = null,

    @Column(name = "LAST_NAME", nullable = false, length = 100)
    var lastName: String? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Transient
    var fullName: String? = null,

    @Column(name = "SUMMARY", length = 600, columnDefinition = "TEXT")
    var summary: String? = null,

    @ElementCollection
    @CollectionTable(name = "PROFILES_PHONES", joinColumns = [JoinColumn(name = "PROFILE_ID")])
    var phones: List<String> = emptyList(),

    @ElementCollection
    @CollectionTable(name = "PROFILES_EMAILS", joinColumns = [JoinColumn(name = "PROFILE_ID")])
    var emails: List<String> = emptyList(),

    @OneToOne
    var location: Location? = null,

    @ElementCollection
    @CollectionTable(name = "PROFILES_TECHNOLOGIES", joinColumns = [JoinColumn(name = "PROFILE_ID")])
    var technologies: List<String> = emptyList(),

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var skills: List<Skill> = emptyList(),

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var schools: List<School> = emptyList(),

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var works: List<Work> = emptyList(),

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var projects: List<Project> = emptyList(),

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var socialProfiles: List<SocialProfile> = emptyList(),

    @Column(name = "PROFILE_CV_URL")
    @URL
    var profileUrl: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
