package com.example.fitness.data.repository

import com.example.fitness.data.entity.UserEntity

interface UserRepository {
    /**
     * Retrieve user from the given data source that matches with the [username], [password]
     */
    fun loginStream(username: String,password: String): UserEntity?

    /**
     * Insert item in the data source
     */
    suspend fun insertUser(userEntity: UserEntity)

    /**
     * Update item in the data source
     */
    suspend fun updateUser(userEntity: UserEntity)

    /**
     * Update firstname and lastname per user Id
     */
    suspend fun setNaming (userId: Long, firstname: String, lastname: String, age: String)


    /**
     * Update gender per user Id
     */
    suspend fun setGender(userId: Long, gender: String)

    /**
     * Update height per user Id
     */
    suspend fun setHeight(userId: Long, height: String)

    /**
     * Update height per user Id
     */
    suspend fun setWeight(userId: Long, weight: String)

    /**
     * Update body type per user Id
     */
    suspend fun setBodytype(userId: Long, bodytype: String)

    /**
     * Update body fat per user Id
     */
    suspend fun setBodyfat(userId: Long, bodyfat: String)

    /**
     * Update body fat per user Id
     */
    suspend fun setBodygoals(userId: Long, bodygoals: String)

    /**
     * Updating the personal details
     */
    suspend fun setProfile(userId: Long, profilePic: String, firstname: String,lastname: String,height: String,weight: String,age: String, bodyfat: String, gender: String, bodytype: String)

    /**
     * Getting userID First name + Last name + Height + Weight + Age + bodyfat + bodytype
     */
    suspend fun getUserId(userId: Long): UserEntity?

}