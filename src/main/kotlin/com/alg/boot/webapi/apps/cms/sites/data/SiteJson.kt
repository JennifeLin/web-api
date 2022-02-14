package com.alg.boot.webapi.apps.cms.sites.data

import java.time.Instant

class SiteJson {
    var id: Long? = null
    var name: String? = null
    var domain: String? = null
    var googleSiteVerification: String? = null
    var googleAnalyticsId: String? = null
    var googleContainerId: String? = null
    var facebookPageId: String? = null
    var facebookAppId: String? = null
    var facebookPixelId: String? = null
    var facebookLatitude: String? = null
    var facebookLongitude: String? = null
    var facebookAddress: String? = null
    var facebookCity: String? = null
    var facebookRegion: String? = null
    var facebookCountry: String? = null
    var settings: List<SettingJson> = emptyList()
    var createdAt: Instant? = null
    var updatedAt: Instant? = null
}
