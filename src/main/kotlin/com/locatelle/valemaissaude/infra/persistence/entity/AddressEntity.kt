package com.locatelle.valemaissaude.infra.persistence.entity

import com.locatelle.valemaissaude.domain.model.AddressModel
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_address")
class AddressEntity(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    val id: UUID? = null,

    @Column(name = "cep", nullable = false)
    val cep: String,

    @Column(name = "state", nullable = false)
    val state: String,

    @Column(name = "city", nullable = false)
    val city: String,

    @Column(name = "district", nullable = false)
    val district: String,

    @Column(name = "street", nullable = false)
    val street: String,

    @Column(name = "house_number", nullable = true)
    val houseNumber: String
) {

    fun toAddressModel() = AddressModel(
        id = id,
        cep = cep,
        state = state,
        city = city,
        district = district,
        street = street,
        houseNumber = houseNumber
    )

    companion object {
        fun of(address: AddressModel) = AddressEntity(
            id = address.id,
            cep = address.cep,
            state = address.state,
            city = address.city,
            district = address.district,
            street = address.street,
            houseNumber = address.houseNumber
        )
    }
}
