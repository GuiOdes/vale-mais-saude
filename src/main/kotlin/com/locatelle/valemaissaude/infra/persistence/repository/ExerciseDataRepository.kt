package com.locatelle.valemaissaude.infra.persistence.repository

import com.locatelle.valemaissaude.infra.persistence.entity.ExerciseEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ExerciseDataRepository : JpaRepository<ExerciseEntity, UUID>
