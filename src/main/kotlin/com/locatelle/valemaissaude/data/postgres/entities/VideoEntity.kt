package com.locatelle.valemaissaude.data.postgres.entities

import com.locatelle.valemaissaude.models.VideoModel
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
    val id: UUID,

    @Column(name = "reference", nullable = false)
    val reference: String
) {

    fun toVideoModel() = VideoModel(
        id = id,
        reference = reference
    )
}
