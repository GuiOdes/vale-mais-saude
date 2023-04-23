package com.locatelle.valemaissaude.adapter.response

import com.locatelle.valemaissaude.domain.exceptions.BaseException
import java.time.LocalDateTime

data class ResponseError(
    val code: Int,
    val message: String,
    val timestamp: LocalDateTime? = LocalDateTime.now()
) {

    companion object {
        fun of(baseException: BaseException) = ResponseError(
            code = baseException.code,
            message = baseException.message
        )
    }
}
