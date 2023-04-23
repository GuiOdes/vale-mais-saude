package com.locatelle.valemaissaude.infra.persistence.repository

import com.locatelle.valemaissaude.infra.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserDataRepository : JpaRepository<UserEntity, UUID> {
    fun findByCpf(cpf: String): UserEntity?
}
