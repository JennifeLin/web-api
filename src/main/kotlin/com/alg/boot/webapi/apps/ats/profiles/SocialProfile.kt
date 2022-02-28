package com.alg.boot.webapi.apps.ats.profiles

import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.arthurolg.enums.SocialNetwork
import javax.persistence.*

@Entity
@Table(name = "SOCIAL_PROFILES", uniqueConstraints = [UniqueConstraint(columnNames = ["TYPE_SOCIAL_PROFILE","SOCIAL_PROFILE_ID"])])
class SocialProfile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "TYPE_SOCIAL_PROFILE", nullable = false)
    @Enumerated(EnumType.STRING)
    var type: SocialNetwork = SocialNetwork.FACEBOOK,

    @Column(name = "SOCIAL_PROFILE_ID", length = 160, nullable = false)
    var userId: String? = null,

    @Transient
    var url: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFILE_ID", nullable = false)
    var profile: Profile? = null
): AuditableEntity<String>()
