package com.locatelle.valemaissaude.data.postgres.entities

import com.locatelle.valemaissaude.data.enums.ExerciseGroupEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "TB_EXERCISE")
class ExerciseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "explanation", nullable = false)
    val explanation: String,

    @Column(name = "count_sets", nullable = false)
    val countSets: Int,

    @Column(name = "set_repetition_count", nullable = false)
    val setRepetitionCount: Int,

    @Column(name = "repetition_duration", nullable = false)
    val repetitionDuration: Int,

    @Enumerated(STRING)
    @Column(name = "exercise_group", nullable = false)
    val group: ExerciseGroupEnum,

    @OneToMany
    val video: List<VideoEntity>
)
