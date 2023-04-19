package com.locatelle.valemaissaude.data.postgres.entities

import com.locatelle.valemaissaude.data.enums.GenderEnum
import com.locatelle.valemaissaude.data.enums.UserTypeEnum
import com.locatelle.valemaissaude.data.enums.UserTypeEnum.DEFAULT
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "tb_user")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(name = "full_name", nullable = false)
    val fullName: String,

    @Column(name = "birth_date", nullable = true)
    val birthDate: LocalDate,

    @Column(name = "cpf", nullable = false, unique = true)
    val cpf: String,

    @Column(name = "gender", nullable = true)
    val gender: GenderEnum,

    @Column(name = "phone_number", nullable = true, unique = true)
    val phoneNumber: String,

    @Column(name = "email", nullable = false, unique = true)
    val email: String,

    @Column(name = "password", nullable = true)
    val password: String,

    @OneToOne
    @JoinColumn(name = "profile_photo_id", nullable = true)
    val profilePhoto: ImageEntity,

    @OneToOne
    @JoinColumn(name = "address", nullable = true)
    val address: AddressEntity,

    @Enumerated(STRING)
    @Column(name = "cep", nullable = false)
    val userType: UserTypeEnum? = DEFAULT
)
