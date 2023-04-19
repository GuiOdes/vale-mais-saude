package com.locatelle.valemaissaude.data.postgres

import com.locatelle.valemaissaude.data.postgres.entities.VideoEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface VideoDataRepository : JpaRepository<VideoEntity, UUID>
