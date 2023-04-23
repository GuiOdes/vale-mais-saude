package com.locatelle.valemaissaude.infra.persistence.repository

import com.locatelle.valemaissaude.infra.persistence.entity.ImageEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ImageDataRepository : JpaRepository<ImageEntity, UUID>
