package com.locatelle.valemaissaude.data.postgres

import com.locatelle.valemaissaude.data.postgres.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<UserEntity, UUID>
