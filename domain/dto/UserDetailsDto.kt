package com.example.fitness.domain.dto

import com.example.fitness.data.entity.UserEntity

//User Data transfer objects
data class UserDetailsDto(
    val id: Long = 0,
    val username: String = "",
    val profilepic: String = "",
    val password: String = "",
    val firstname: String = "",
    val lastname: String = "",
    val age: String = "",
    val height: String = "",
    val weight: String = "",
    val gender: String = "",
    val bodytype: String = "",
    val bodyfat: String = "",
    val bodygoals: String = "",
    val loginTime: Long = 0
)


/**
 * Extension function to convert [ItemDetails] to [Item]. If the value of [ItemDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [ItemDetails.quantity] is not a valid [Int], then the quantity will be set to 0
 */
fun UserDetailsDto.toUserEntity(): UserEntity = UserEntity(
    profilepic = profilepic,
    username  = username,
     password  = password,
     firstname  = firstname,
     lastname  = lastname,
     age  = age,
     height  = height,
     weight  = weight,
     gender  = gender,
     bodytype  = bodytype,
     bodyfat  = bodyfat,
     bodygoals  = bodygoals,
     loginTime = loginTime,
)

/**
 * Extension function to convert [UserEntity] to [UserDetailsDto]
 */
fun UserEntity.toUserDetailsDto(): UserDetailsDto = UserDetailsDto(
    id = id,
    profilepic = profilepic,
    username  = username,
    password  = password,
    firstname  = firstname,
    lastname  = lastname,
    age  = age,
    height  = height,
    weight  = weight,
    gender  = gender,
    bodytype  = bodytype,
    bodyfat  = bodyfat,
    bodygoals  = bodygoals,
    loginTime = loginTime,
)