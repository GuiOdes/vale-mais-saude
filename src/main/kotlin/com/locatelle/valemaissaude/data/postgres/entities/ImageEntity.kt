package com.locatelle.valemaissaude.data.postgres.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tb_image")
class ImageEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,

    @Column(name = "reference", nullable = false)
    val reference: String
)
