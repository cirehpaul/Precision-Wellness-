package com.example.fitness.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "user")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
    val username: String = "",
    val password: String = "",
    val firstname: String = "",
    val lastname: String = "",
    val age: String = "",
    val height: String = "",
    val weight: String = "",
    val gender: String = "",
    val profilepic: String = "",
    val bodytype: String = "", //beginner, intermediate, advance
    val bodyfat: String = "",  //lean, athletic, natural
    val bodygoals: String = "",  //enhance (enhance athletic performance), build (build lean muscle mass), increase (increase agility and endurance)
    val loginTime: Long = 0
)