package com.locatelle.valemaissaude.utils

import com.locatelle.valemaissaude.exceptions.BaseException
import java.util.UUID

const val MINUTES_PER_HOUR = 60
const val MILLIS_PER_MINUTE = 1000

fun stringToUUID(value: String): UUID {
    return runCatching {
        UUID.fromString(value)
    }.onFailure {
        throw BaseException(message = "Invalid UUID value!", code = 400)
    }.getOrThrow()
}
fun getMillisByMinute(minutes: Int) = minutes * MINUTES_PER_HOUR * MILLIS_PER_MINUTE
