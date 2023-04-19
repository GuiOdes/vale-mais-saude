package com.locatelle.valemaissaude.data.postgres

import com.locatelle.valemaissaude.data.postgres.entities.ExerciseEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ExerciseDataRepository : JpaRepository<ExerciseEntity, UUID>
