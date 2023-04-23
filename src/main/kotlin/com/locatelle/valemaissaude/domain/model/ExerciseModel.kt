package com.locatelle.valemaissaude.domain.model

import com.locatelle.valemaissaude.domain.model.enum.ExerciseGroupEnum
import java.util.UUID

class ExerciseModel(
    val id: UUID? = null,
    val title: String,
    val explanation: String,
    val countSets: Int,
    val setRepetitionCount: Int,
    val repetitionDuration: Int,
    val group: ExerciseGroupEnum,
    val videos: List<VideoModel>,
    val professionalModel: UserModel
)
