package com.example.fitness.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.fitness.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun loginUser(username: String, password: String): UserEntity?

    @Query("SELECT * FROM user WHERE username = :username")
    fun getUserByUsername(username: String): Flow<UserEntity?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userEntity: UserEntity)

    @Update
    suspend fun update(userEntity: UserEntity)

    @Query("UPDATE user SET firstname = :firstname, lastname = :lastname, age = :age WHERE id = :userId")
    fun setNaming(userId: Long,  firstname: String, lastname:String, age: String)

    @Query("UPDATE user SET gender = :gender WHERE id = :userId")
    fun setGender(userId: Long, gender: String)

    @Query("UPDATE user SET height = :height WHERE id = :userId")
    fun setHeight(userId: Long, height: String)

    @Query("UPDATE user SET weight = :weight WHERE id = :userId")
    fun setWeight(userId: Long, weight: String)

    @Query("UPDATE user SET bodytype = :bodytype WHERE id = :userId")
    fun setBodytype(userId: Long, bodytype: String)

    @Query("UPDATE user SET bodyfat = :bodyfat WHERE id = :userId")
    fun setBodyfat(userId: Long, bodyfat: String)

    @Query("UPDATE user SET bodygoals = :bodygoals WHERE id = :userId")
    fun setBodygoals(userId: Long, bodygoals: String)

    @Query("UPDATE user SET profilepic = :profilepic, firstname = :firstname, lastname = :lastname, age = :age, gender = :gender, height = :height, weight = :weight, bodyfat = :bodyfat, bodytype = :bodytype WHERE id = :userId")
    fun setProfile(userId: Long, profilepic: String, firstname: String,lastname: String,  age: String,  gender: String, height: String,  weight: String, bodyfat: String,bodytype: String)

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserByUserId(id:Long): UserEntity?
}
