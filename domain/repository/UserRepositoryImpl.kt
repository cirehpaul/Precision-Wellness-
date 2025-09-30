package com.example.fitness.domain.repository

import com.example.fitness.data.dao.UserDao
import com.example.fitness.data.entity.UserEntity
import com.example.fitness.data.repository.UserRepository

class UserRepositoryImpL(private val userDao: UserDao) : UserRepository {

    override fun loginStream(username: String, password: String): UserEntity? =
        userDao.loginUser(username, password)

    override suspend fun insertUser(userEntity: UserEntity) = userDao.insert(userEntity)

    override suspend fun updateUser(userEntity: UserEntity) = userDao.update(userEntity)

    override suspend fun setNaming(userId: Long, firstname: String, lastname: String, age: String) =
        userDao.setNaming(userId, firstname, lastname, age)

    override suspend fun setGender(userId: Long, gender: String) = userDao.setGender(userId, gender)

    override suspend fun setHeight(userId: Long, height: String) = userDao.setHeight(userId, height)

    override suspend fun setWeight(userId: Long, weight: String) = userDao.setWeight(userId, weight)

    override suspend fun setBodytype(userId: Long, bodytype: String) =
        userDao.setBodytype(userId, bodytype)

    override suspend fun setBodyfat(userId: Long, bodyfat: String) =
        userDao.setBodyfat(userId, bodyfat)

    override suspend fun setBodygoals(userId: Long, bodygoals: String) =
        userDao.setBodygoals(userId, bodygoals)

    override suspend fun setProfile(
        userId: Long,
        profilePic: String,
        firstname: String,
        lastname: String,
        height: String,
        weight: String,
        age: String,
        bodyfat: String,
        gender: String,
        bodytype: String) = userDao.setProfile(
        userId = userId,
        profilepic = profilePic,
        firstname = firstname,
        lastname = lastname,
        height = height,
        weight = weight,
        age = age,
        bodyfat = bodyfat,
        gender = gender,
        bodytype = bodytype
    )

    override suspend fun getUserId(userId: Long) : UserEntity? =
        userDao.getUserByUserId(userId)


}
