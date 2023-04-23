package com.locatelle.valemaissaude.infra.persistence.implementation

import com.locatelle.valemaissaude.domain.model.UserModel
import com.locatelle.valemaissaude.domain.repository.UserRepository
import com.locatelle.valemaissaude.infra.persistence.entity.UserEntity
import com.locatelle.valemaissaude.infra.persistence.repository.AddressDataRepository
import com.locatelle.valemaissaude.infra.persistence.repository.ImageDataRepository
import com.locatelle.valemaissaude.infra.persistence.repository.UserDataRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryImpl(
    private val userDataRepository: UserDataRepository,
    private val imageDataRepository: ImageDataRepository,
    private val addressDataRepository: AddressDataRepository
) : UserRepository {

    override fun save(userModel: UserModel): UserModel {
        val professionalEntity = userModel.professionalId?.let {
            runCatching { userDataRepository.findById(userModel.professionalId).get() }.getOrNull()
        }

        return userDataRepository.save(UserEntity.of(userModel, professionalEntity)).toUserModel()
    }

    override fun findByDocument(cpf: String): UserModel? {
        return userDataRepository.findByCpf(cpf)?.toUserModel()
    }
}
