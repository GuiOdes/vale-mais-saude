package com.locatelle.valemaissaude.data.postgres

import com.locatelle.valemaissaude.data.postgres.entities.ImageEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ImageRepository : JpaRepository<ImageEntity, UUID>
