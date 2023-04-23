package com.locatelle.valemaissaude.infra.persistence.repository

import com.locatelle.valemaissaude.infra.persistence.entity.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AddressDataRepository : JpaRepository<AddressEntity, UUID>
