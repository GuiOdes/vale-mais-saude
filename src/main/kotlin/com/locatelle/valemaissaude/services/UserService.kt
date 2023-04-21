package com.locatelle.valemaissaude.services

import com.locatelle.valemaissaude.exceptions.BaseException
import com.locatelle.valemaissaude.models.UserModel
import com.locatelle.valemaissaude.repositories.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val userModel = userRepository.findByDocument(username ?: "")
            ?: throw BaseException(message = "User not found!", code = 404)
        return User(userModel.cpf, userModel.password, listOf(SimpleGrantedAuthority(userModel.userType!!.name)))
    }

    fun create(userModel: UserModel): UserModel {

        return userRepository.save(
            userModel.copy(
                password = passwordEncoder.encode(userModel.password),
                cpf = userModel.cpf.replace("[.\\-/]".toRegex(), "")
            )
        )
    }
}
