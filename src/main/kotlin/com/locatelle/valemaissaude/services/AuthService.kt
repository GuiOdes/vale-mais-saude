package com.locatelle.valemaissaude.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.fasterxml.jackson.databind.ObjectMapper
import com.locatelle.valemaissaude.models.UserModel
import com.locatelle.valemaissaude.repositories.UserRepository
import com.locatelle.valemaissaude.utils.getMillisByMinute
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.Date
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
class AuthService(
    private val userRepository: UserRepository
) {

    private fun isValidAuthorizationHeader(authorizationHeader: String?) =
        authorizationHeader.isNullOrBlank().not() && authorizationHeader!!.startsWith("Bearer ")

    fun doRefreshToken(
        authorizationHeader: String?,
        request: HttpServletRequest,
        response: HttpServletResponse
    ) {
        if (isValidAuthorizationHeader(authorizationHeader)) {
            val refreshToken = authorizationHeader!!.substring("Bearer ".length)
            val algorithm = Algorithm.HMAC256("secret".toByteArray())
            val verifier = JWT.require(algorithm).build()
            val decodedJWT = verifier.verify(refreshToken)
            val userDocument = decodedJWT.subject
            val userModel = userRepository.findByDocument(userDocument) ?: throw RuntimeException("User not found!")

            val accessToken = generateToken(userModel, request, algorithm, AUTH_TOKEN_EXPIRATION_MINUTES)
            val newRefreshToken = generateToken(userModel, request, algorithm, REFRESH_TOKEN_EXPIRATION_MINUTES)

            val responseAttributes = mutableMapOf<String, String>()
            responseAttributes["access_token"] = accessToken
            responseAttributes["refresh_token"] = newRefreshToken
            responseAttributes["userCpf"] = userModel.cpf
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            ObjectMapper().writeValue(response.outputStream, responseAttributes)
        } else {
            throw RuntimeException("Invalid refresh token!")
        }
    }

    private fun generateToken(
        userModel: UserModel,
        request: HttpServletRequest,
        algorithm: Algorithm?,
        minutesExpiration: Int
    ) = JWT.create()
        .withSubject(userModel.cpf)
        .withExpiresAt(
            Date(System.currentTimeMillis() + getMillisByMinute(minutesExpiration))
        )
        .withIssuer(request.requestURL.toString())
        .withClaim("role", userModel.userType!!.name)
        .sign(algorithm)

    companion object {
        private const val AUTH_TOKEN_EXPIRATION_MINUTES = 60
        private const val REFRESH_TOKEN_EXPIRATION_MINUTES = 120
    }
}
