package com.locatelle.valemaissaude.models

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
