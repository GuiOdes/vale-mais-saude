package com.locatelle.valemaissaude.adapter.controller

import com.locatelle.valemaissaude.adapter.service.UserService
import com.locatelle.valemaissaude.domain.model.UserModel
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun create(@RequestBody userModel: UserModel): UserModel {
        return userService.create(userModel)
    }
}
