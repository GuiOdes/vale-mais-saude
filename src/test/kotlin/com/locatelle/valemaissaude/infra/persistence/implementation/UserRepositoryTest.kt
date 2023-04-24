package com.locatelle.valemaissaude.infra.persistence.implementation

import com.locatelle.valemaissaude.common.BaseTestContainerConfiguration
import com.locatelle.valemaissaude.common.TestContainerCommon
import com.locatelle.valemaissaude.domain.repository.UserRepository
import com.locatelle.valemaissaude.infra.persistence.repository.AddressDataRepository
import com.locatelle.valemaissaude.infra.persistence.repository.ImageDataRepository
import com.locatelle.valemaissaude.infra.persistence.repository.UserDataRepository
import com.locatelle.valemaissaude.mocks.userModelFixture
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@TestContainerCommon
class UserRepositoryTest(
    @Autowired private val userDataRepository: UserDataRepository,
    @Autowired private val imageDataRepository: ImageDataRepository,
    @Autowired private val addressDataRepository: AddressDataRepository
) : BaseTestContainerConfiguration() {

    private var userRepository: UserRepository = UserRepositoryImpl(
        userDataRepository = userDataRepository,
        imageDataRepository = imageDataRepository,
        addressDataRepository = addressDataRepository
    )

    @Test
    fun `should save an user on database and find it by id`() {
        val userToSave = userModelFixture()

        val savedUser = userRepository.save(userToSave)

        assertEquals(userRepository.findByDocument(userToSave.cpf)?.id, savedUser.id)
    }
}
