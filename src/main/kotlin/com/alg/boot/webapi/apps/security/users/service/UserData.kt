package com.alg.boot.webapi.apps.security.users.service

import com.alg.boot.webapi.apps.security.jwt.AuthenticationResponse
import com.alg.boot.webapi.apps.security.jwt.TokenProviderJWT
import com.alg.boot.webapi.apps.security.roles.RoleRepository
import com.alg.boot.webapi.apps.security.users.User
import com.alg.boot.webapi.apps.security.users.UserRepository
import com.alg.boot.webapi.apps.security.users.dto.UserLoginRequest
import com.alg.boot.webapi.apps.security.users.dto.UserRegisterRequest
import com.alg.boot.webapi.handlers.exceptions.BadRequestException
import com.alg.boot.webapi.handlers.exceptions.ServerErrorException
import com.arthurolg.constants.AuthoritiesConstants
import com.arthurolg.utils.PasswordUtil
import org.modelmapper.ModelMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserData(
    private val authenticationManager: AuthenticationManager,
    private val modelMapper: ModelMapper,
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository,
    private val tokenProviderJWT: TokenProviderJWT,
    private val userRepository: UserRepository
) : UserService {

    override fun authenticate(login: UserLoginRequest) : AuthenticationResponse {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(login.username, login.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        val token = tokenProviderJWT.generateToken(authentication)
        val authenticationJWT = AuthenticationResponse()
        authenticationJWT.token = token
        return authenticationJWT
    }

    @Transactional
    override fun register(user: UserRegisterRequest): String {
        if (user.password != user.confirmPassword) throw BadRequestException("La confirmación de la contraseña no es igual")
        if (userRepository.existsByUsername(user.username!!)) throw BadRequestException("No se puede registrar con ese nombre de usuario")
        val role = roleRepository.findByName(AuthoritiesConstants.ROLE_ADMIN).orElseThrow {
            ServerErrorException("No se puede asignar el rol '${AuthoritiesConstants.ROLE_ADMIN}'")
        }
        val userModel = modelMapper.map(user, User::class.java)
        val salt = PasswordUtil.getMd5Hash(user.username)
        val password = "${user.password}:${salt}"
        userModel.salt = salt
        userModel.password = passwordEncoder.encode(password)
        userModel.roles = mutableSetOf(role)
        userModel.isEnabled = true
        userRepository.save(userModel)
        return "Usuario registrado ${user.username}"
    }
}
