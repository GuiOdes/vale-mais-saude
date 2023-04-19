package com.locatelle.valemaissaude.data.postgres.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tb_address")
class AddressEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(name = "cep", nullable = false)
    val cep: String,

    @Column(name = "state", nullable = false)
    val state: String,

    @Column(name = "city", nullable = false)
    val city: String,

    @Column(name = "district", nullable = false)
    val district: String,

    @Column(name = "street", nullable = false)
    val street: String,

    @Column(name = "house_number", nullable = true)
    val houseNumber: String
)
