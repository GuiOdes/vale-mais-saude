package com.locatelle.valemaissaude.models

import com.locatelle.valemaissaude.enums.ExerciseGroupEnum
import java.util.UUID

class ExerciseModel(
    val id: UUID? = null,
    val title: String,
    val explanation: String,
    val countSets: Int,
    val setRepetitionCount: Int,
    val repetitionDuration: Int,
    val group: ExerciseGroupEnum,
    val videos: List<VideoModel>
)
