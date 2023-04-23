package com.locatelle.valemaissaude.adapter.service

import com.auth0.jwt.algorithms.Algorithm
import com.locatelle.valemaissaude.domain.model.UserModel
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface AuthService {
    fun isValidAuthorizationHeader(authorizationHeader: String?): Boolean
    fun doRefreshToken(
        authorizationHeader: String?,
        request: HttpServletRequest,
        response: HttpServletResponse
    )

    fun generateToken(
        userModel: UserModel,
        request: HttpServletRequest,
        algorithm: Algorithm?,
        minutesExpiration: Int
    ): String?
}
