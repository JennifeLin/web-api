package com.alg.boot.webapi.apps.ats.profiles

import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository: JpaRepository<Profile, Long>
