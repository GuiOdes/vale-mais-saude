package com.locatelle.valemaissaude.domain.exceptions

import com.locatelle.valemaissaude.adapter.response.ResponseError
import com.locatelle.valemaissaude.utils.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(BaseException::class)
    fun baseExceptionHandler(exception: BaseException): ResponseEntity<ResponseError> {
        return ResponseEntity(ResponseError.of(exception), HttpStatus.valueOf(exception.code))
    }

    @ExceptionHandler(Exception::class)
    fun unexpectedExceptionHandler(exception: Exception): ResponseEntity<ResponseError> {
        logger.error("Unexpected exception: ${exception.message}", exception)

        return ResponseEntity(
            ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Unexpected error has occurred!"),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}
