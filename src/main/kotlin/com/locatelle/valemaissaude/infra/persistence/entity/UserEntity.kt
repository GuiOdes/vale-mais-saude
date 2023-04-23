package com.locatelle.valemaissaude.infra.persistence.entity

import com.locatelle.valemaissaude.domain.model.UserModel
import com.locatelle.valemaissaude.domain.model.enum.GenderEnum
import com.locatelle.valemaissaude.domain.model.enum.UserTypeEnum
import com.locatelle.valemaissaude.domain.model.enum.UserTypeEnum.DEFAULT
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "tb_user")
class UserEntity(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    val id: UUID? = null,

    @Column(name = "full_name", nullable = false)
    val fullName: String,

    @Column(name = "birth_date", nullable = true)
    val birthDate: LocalDate,

    @Column(name = "cpf", nullable = false, unique = true)
    val cpf: String,

    @Column(name = "gender", nullable = true)
    val gender: GenderEnum,

    @Column(name = "phone_number", nullable = true, unique = true)
    val phoneNumber: String,

    @Column(name = "email", nullable = false, unique = true)
    val email: String,

    @Column(name = "password", nullable = true)
    val password: String,

    @OneToOne
    @JoinColumn(name = "profile_photo_id", nullable = true)
    val profilePhoto: ImageEntity? = null,

    @OneToOne
    @JoinColumn(name = "address_id", nullable = true)
    val address: AddressEntity? = null,

    @Enumerated(STRING)
    @Column(name = "user_type", nullable = false)
    val userType: UserTypeEnum? = DEFAULT,

    @ManyToOne
    @JoinColumn(name = "professional_id", nullable = true)
    val professionalId: UserEntity? = null
) {

    fun toUserModel() = UserModel(
        id = id,
        fullName = fullName,
        birthDate = birthDate,
        cpf = cpf,
        gender = gender,
        phoneNumber = phoneNumber,
        email = email,
        password = password,
        profilePhoto = profilePhoto?.toImageModel(),
        address = address?.toAddressModel(),
        userType = userType,
        professionalId = professionalId?.id
    )

    companion object {

        fun of(
            userModel: UserModel,
            professionalEntity: UserEntity?
        ) = UserEntity(
            id = userModel.id,
            fullName = userModel.fullName,
            birthDate = userModel.birthDate,
            cpf = userModel.cpf,
            gender = userModel.gender,
            phoneNumber = userModel.phoneNumber,
            email = userModel.email,
            password = userModel.password,
            profilePhoto = userModel.profilePhoto?.let { ImageEntity.of(userModel.profilePhoto) },
            address = userModel.address?.let { AddressEntity.of(userModel.address) },
            userType = userModel.userType,
            professionalId = professionalEntity
        )
    }
}
