package com.alg.boot.webapi.apps.cms.sites.data

import java.time.Instant

class SettingJson {
    var id: Long? = null
    var property: String? = null
    val type: String? = null
    var value: String? = null
    var createdAt: Instant? = null
    var updatedAt: Instant? = null
}
