package com.locatelle.valemaissaude.domain.model

import com.locatelle.valemaissaude.domain.model.enum.GenderEnum
import com.locatelle.valemaissaude.domain.model.enum.UserTypeEnum
import com.locatelle.valemaissaude.domain.model.enum.UserTypeEnum.DEFAULT
import java.time.LocalDate
import java.util.UUID

data class UserModel(
    val id: UUID? = null,
    val fullName: String,
    val birthDate: LocalDate,
    val cpf: String,
    val gender: GenderEnum,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val profilePhoto: ImageModel? = null,
    val address: AddressModel? = null,
    val userType: UserTypeEnum? = DEFAULT,
    val professionalId: UUID? = null
)
