package com.locatelle.valemaissaude.common

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc

@ExtendWith(SpringExtension::class)
open class BaseControllerTest(
    mockMvc: MockMvc,
    mapper: ObjectMapper
)
