package com.alg.boot.webapi.apps.ats.profiles

import com.alg.boot.webapi.enums.TypeSocialNetwork
import org.hibernate.validator.constraints.URL
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "SOCIAL_PROFILES")
class SocialProfile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "TYPE_SOCIAL_PROFILE")
    @Enumerated(EnumType.STRING)
    var type: TypeSocialNetwork = TypeSocialNetwork.FACEBOOK,

    @Column(name = "URL_SOCIAL_PROFILE")
    @URL
    var url: String? = null,

    @Column(name = "SOCIAL_PROFILE_ID", length = 160)
    var userId: String? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
