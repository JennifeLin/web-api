package com.alg.boot.webapi.apps.security.users.dto

import javax.validation.constraints.NotBlank

class UserLoginRequest {
    @NotBlank
    val username: String? = null
    @NotBlank
    val password: String? = null
}
