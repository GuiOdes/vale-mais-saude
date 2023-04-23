package com.locatelle.valemaissaude.adapter.service

import com.locatelle.valemaissaude.domain.model.UserModel
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun create(userModel: UserModel): UserModel
}
