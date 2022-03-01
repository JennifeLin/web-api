package com.alg.boot.webapi.apps.security.users.dto

import javax.validation.constraints.NotBlank

class UserRegisterRequest {
    @NotBlank
    var username: String? = null
    @NotBlank
    var password: String? = null
    @NotBlank
    var confirmPassword: String? = null
}
