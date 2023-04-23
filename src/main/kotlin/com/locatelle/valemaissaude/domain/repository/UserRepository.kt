package com.locatelle.valemaissaude.domain.repository

import com.locatelle.valemaissaude.domain.model.UserModel

interface UserRepository {
    fun save(userModel: UserModel): UserModel
    fun findByDocument(cpf: String): UserModel?
}
