package com.locatelle.valemaissaude.data.postgres.entities

import com.locatelle.valemaissaude.models.ImageModel
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_image")
class ImageEntity(

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

    fun toImageModel() = ImageModel(
        id = id,
        reference = reference
    )

    companion object {
        fun of(imageModel: ImageModel) = ImageEntity(
            id = imageModel.id,
            reference = imageModel.reference
        )
    }
}
