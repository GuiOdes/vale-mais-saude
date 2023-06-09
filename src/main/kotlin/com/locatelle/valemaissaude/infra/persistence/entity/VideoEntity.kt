package com.locatelle.valemaissaude.infra.persistence.entity

import com.locatelle.valemaissaude.domain.model.VideoModel
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_video")
class VideoEntity(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    val id: UUID? = null,

    @Column(name = "reference", nullable = false)
    val reference: String
) {

    fun toVideoModel() = VideoModel(
        id = id,
        reference = reference
    )

    companion object {
        fun of(videoModel: VideoModel) = VideoEntity(
            id = videoModel.id,
            reference = videoModel.reference
        )
    }
}
