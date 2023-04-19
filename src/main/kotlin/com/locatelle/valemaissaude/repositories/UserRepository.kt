package com.locatelle.valemaissaude.repositories

import com.locatelle.valemaissaude.data.postgres.AddressDataRepository
import com.locatelle.valemaissaude.data.postgres.ImageDataRepository
import com.locatelle.valemaissaude.data.postgres.UserDataRepository
import com.locatelle.valemaissaude.data.postgres.entities.UserEntity
import com.locatelle.valemaissaude.models.UserModel
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class UserRepository(
    private val userDataRepository: UserDataRepository,
    private val imageDataRepository: ImageDataRepository,
    private val addressDataRepository: AddressDataRepository
) {

    fun save(userModel: UserModel): UserModel {
        val professionalEntity = userModel.professionalId?.let {
            runCatching { userDataRepository.findById(userModel.professionalId).get() }.getOrNull()
        }

        return userDataRepository.save(UserEntity.of(userModel, professionalEntity)).toUserModel()
    }

    fun findByDocument(cpf: String): UserModel? {
        return userDataRepository.findByCpf(cpf)?.toUserModel()
    }
}
