package com.alg.boot.webapi.apps.cms.sites

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "SITES", uniqueConstraints = [UniqueConstraint(columnNames = ["NAME", "DOMAIN"])])
class Site(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "NAME", length = 160, unique = true, nullable = false)
    @NotBlank
    var name: String,

    @Column(name = "DOMAIN", unique = true, nullable = false)
    @NotBlank
    var domain: String? = null,

    @Column(name = "G_SITE_VERIFICATION")
    var googleSiteVerification: String? = null,

    @Column(name = "G_ANALYTICS_ID")
    var googleAnalyticsId: String? = null,

    @Column(name = "G_CONTAINER_ID")
    var googleContainerId: String? = null,

    @Column(name = "FB_PAGE_ID")
    var facebookPageId: String? = null,

    @Column(name = "FB_APP_ID")
    var facebookAppId: String? = null,

    @Column(name = "FB_PIXEL_ID")
    var facebookPixelId: String? = null,

    @Column(name = "FB_LATITUDE")
    var facebookLatitude: String? = null,

    @Column(name = "FB_LONGITUDE")
    var facebookLongitude: String? = null,

    @Column(name = "FB_ADDRESS")
    var facebookAddress: String? = null,

    @Column(name = "FB_CITY")
    var facebookCity: String? = null,

    @Column(name = "FB_REGION")
    var facebookRegion: String? = null,

    @Column(name = "FB_COUNTRY")
    var facebookCountry: String? = null,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        joinColumns = [JoinColumn(name = "SITE_ID")],
        inverseJoinColumns = [JoinColumn(name = "SETTING_ID")]
    )
    var settings: List<Setting> = emptyList(),

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)
