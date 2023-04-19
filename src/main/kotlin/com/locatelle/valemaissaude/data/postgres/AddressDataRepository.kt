package com.locatelle.valemaissaude.data.postgres

import com.locatelle.valemaissaude.data.postgres.entities.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AddressDataRepository : JpaRepository<AddressEntity, UUID>
