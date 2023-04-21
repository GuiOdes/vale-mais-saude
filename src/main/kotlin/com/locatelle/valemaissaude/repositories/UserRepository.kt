package com.locatelle.valemaissaude.repositories

import com.locatelle.valemaissaude.data.postgres.AddressDataRepository
import com.locatelle.valemaissaude.data.postgres.ImageDataRepository
import com.locatelle.valemaissaude.data.postgres.UserDataRepository
import com.locatelle.valemaissaude.data.postgres.entities.UserEntity
import com.locatelle.valemaissaude.models.UserModel
import com.locatelle.valemaissaude.utils.logger
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class UserRepository(
    private val userDataRepository: UserDataRepository,
    private val imageDataRepository: ImageDataRepository,
    private val addressDataRepository: AddressDataRepository
) {

    fun save(userModel: UserModel): UserModel {
        logger.info { "Starting to save a new user" }
        val professionalEntity = userModel.professionalId?.let {
            runCatching { userDataRepository.findById(userModel.professionalId).get() }.getOrNull()
        }

        return userDataRepository.save(UserEntity.of(userModel, professionalEntity)).toUserModel()
    }

    fun findByDocument(cpf: String): UserModel? {
        logger.info { "Starting to find user by document" }
        return userDataRepository.findByCpf(cpf)?.toUserModel()
    }
}
