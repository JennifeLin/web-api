package com.alg.boot.webapi.apps.ats.profiles

import com.alg.boot.webapi.apps.ats.companies.Location
import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.validator.constraints.URL
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "PROFILES")
class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: UUID? = null,

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

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var skills: MutableList<Skill>? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var schools: MutableList<School>? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var works: MutableList<Work>? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var projects: MutableList<Project>? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "PROFILE_ID")
    var socialProfiles: MutableList<SocialProfile>? = null,

    @Column(name = "PROFILE_CV_URL")
    @URL
    var profileUrl: String? = null,
): AuditableEntity<String>() {
    @PrePersist
    fun prePersistData() {
        this.slug = UUID.randomUUID().toString()
    }
}
