package com.alg.boot.webapi.apps.cms.sites

import org.springframework.data.jpa.repository.JpaRepository

interface SettingRepository: JpaRepository<Setting, Long>
