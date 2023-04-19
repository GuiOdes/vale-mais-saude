package com.locatelle.valemaissaude.controllers

import com.locatelle.valemaissaude.models.UserModel
import com.locatelle.valemaissaude.services.UserService
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
