package com.locatelle.valemaissaude.domain.service

import com.locatelle.valemaissaude.adapter.service.UserService
import com.locatelle.valemaissaude.domain.model.UserModel
import com.locatelle.valemaissaude.domain.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
) : UserService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val userModel = userRepository.findByDocument(username ?: "") ?: throw RuntimeException("User not found")
        return User(userModel.cpf, userModel.password, listOf(SimpleGrantedAuthority(userModel.userType!!.name)))
    }

    override fun create(userModel: UserModel): UserModel {

        return userRepository.save(
            userModel.copy(
                password = passwordEncoder.encode(userModel.password),
                cpf = userModel.cpf.replace("[.\\-/]".toRegex(), "")
            )
        )
    }
}
