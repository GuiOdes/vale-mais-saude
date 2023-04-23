package com.locatelle.valemaissaude.data.postgres.entities

import com.locatelle.valemaissaude.enums.ExerciseGroupEnum
import com.locatelle.valemaissaude.models.ExerciseModel
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "TB_EXERCISE")
class ExerciseEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
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
    val videos: List<VideoEntity>,

    @ManyToOne
    @JoinColumn(name = "professional_id", nullable = false)
    val professionalOwner: UserEntity
) {

    fun toExerciseModel() = ExerciseModel(
        id = id,
        title = title,
        explanation = explanation,
        countSets = countSets,
        setRepetitionCount = setRepetitionCount,
        repetitionDuration = repetitionDuration,
        group = group,
        videos = videos.map { it.toVideoModel() },
        professionalModel = professionalOwner.toUserModel()
    )

    companion object {

        fun of(
            exerciseModel: ExerciseModel,
            professionalOwner: UserEntity
        ) = ExerciseEntity(
            id = exerciseModel.id,
            title = exerciseModel.title,
            explanation = exerciseModel.explanation,
            countSets = exerciseModel.countSets,
            setRepetitionCount = exerciseModel.setRepetitionCount,
            repetitionDuration = exerciseModel.repetitionDuration,
            group = exerciseModel.group,
            videos = exerciseModel.videos.map { VideoEntity.of(it) },
            professionalOwner = professionalOwner
        )
    }
}
