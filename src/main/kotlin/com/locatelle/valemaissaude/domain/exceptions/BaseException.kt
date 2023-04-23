package com.locatelle.valemaissaude.domain.exceptions

import com.locatelle.valemaissaude.utils.logger
import java.lang.RuntimeException

class BaseException(
    val code: Int,
    override val message: String,
    val exception: RuntimeException? = null
) : RuntimeException(message) {

    init {
        logger.error("A new error has occurred: $message", exception)
    }
}
