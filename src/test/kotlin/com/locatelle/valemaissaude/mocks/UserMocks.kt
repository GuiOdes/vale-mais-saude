package com.locatelle.valemaissaude.mocks

import com.locatelle.valemaissaude.domain.model.AddressModel
import com.locatelle.valemaissaude.domain.model.ImageModel
import com.locatelle.valemaissaude.domain.model.UserModel
import com.locatelle.valemaissaude.domain.model.enum.GenderEnum
import com.locatelle.valemaissaude.domain.model.enum.UserTypeEnum
import java.time.LocalDate
import java.util.UUID

fun userModelFixture(
    id: UUID? = null,
    fullName: String = "User test",
    birthDate: LocalDate = LocalDate.now(),
    cpf: String = "914.679.610-00",
    gender: GenderEnum = GenderEnum.MALE,
    phoneNumber: String = "62998761234",
    email: String = "test@user.com",
    password: String = "123456",
    profilePhoto: ImageModel? = null,
    address: AddressModel? = null,
    userType: UserTypeEnum? = UserTypeEnum.DEFAULT,
    professionalId: UUID? = null
) = UserModel(
    id = id,
    fullName = fullName,
    cpf = cpf,
    birthDate = birthDate,
    gender = gender,
    phoneNumber = phoneNumber,
    email = email,
    password = password,
    profilePhoto = profilePhoto,
    address = address,
    userType = userType,
    professionalId = professionalId
)
