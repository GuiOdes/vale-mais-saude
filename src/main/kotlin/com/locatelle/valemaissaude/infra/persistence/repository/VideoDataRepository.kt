package com.locatelle.valemaissaude.infra.persistence.repository

import com.locatelle.valemaissaude.infra.persistence.entity.VideoEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface VideoDataRepository : JpaRepository<VideoEntity, UUID>
