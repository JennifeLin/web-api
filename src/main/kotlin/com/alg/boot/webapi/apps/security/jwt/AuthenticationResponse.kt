package com.alg.boot.webapi.apps.security.jwt

import com.arthurolg.constants.Constants

class AuthenticationResponse {
    var token: String? = null
    val tokenType: String = Constants.TOKEN_PREFIX
}
