package com.locatelle.valemaissaude.domain.model

import java.util.UUID

data class AddressModel(
    val id: UUID? = null,
    val cep: String,
    val state: String,
    val city: String,
    val district: String,
    val street: String,
    val houseNumber: String
)
