package com.alg.boot.webapi.apps.security.users.service

import com.alg.boot.webapi.apps.security.jwt.AuthenticationResponse
import com.alg.boot.webapi.apps.security.users.dto.UserLoginRequest
import com.alg.boot.webapi.apps.security.users.dto.UserRegisterRequest

interface UserService {
    fun authenticate(login: UserLoginRequest) : AuthenticationResponse
    fun register(user: UserRegisterRequest): String
}
