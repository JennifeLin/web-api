package com.alg.boot.webapi.apps.security.users.service

import com.alg.boot.webapi.apps.security.users.dto.UserLoginRequest

interface UserService {
    fun authenticate(login: UserLoginRequest) : String
}
