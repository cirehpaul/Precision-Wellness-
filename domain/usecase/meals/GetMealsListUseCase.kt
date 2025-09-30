package com.example.fitness.domain.usecase.meals

import com.example.fitness.common.BodyFatLevel
import com.example.fitness.common.Constant
import com.example.fitness.common.MealsCategoriesForAthletic
import com.example.fitness.common.MealsCategoriesForLean
import com.example.fitness.common.MealsCategoriesForNatural
import com.example.fitness.domain.dto.MealsDto
import com.example.fitness.domain.dto.toUserDetailsDto
import com.example.fitness.domain.repository.UserRepositoryImpL

class GetMealsListUseCase(private val userRepositoryImpL: UserRepositoryImpL) {
        suspend operator fun invoke(): List<MealsDto> {

            var list = emptyList<MealsDto>()
            //get the user categories
            userRepositoryImpL.getUserId(Constant.userId.longValue)?.toUserDetailsDto()?.let { user ->

                list = when (user.bodyfat) {
                    BodyFatLevel.LEAN.name -> {
                        generateMealsForLean()
                    }

                    BodyFatLevel.ATHLETIC.name -> {
                        generateMealsForAthletic()
                    }

                    BodyFatLevel.NATURAL.name-> {
                        generateMealsForNatural()
                    }
                    else ->{
                        generateMealsForLean()
                    }
                }
            }

            return list
        }


    /**********************************************************
     * generate meals depending on the Body Fats
     **********************************************************
     * **/
    private fun generateMealsForLean(): List<MealsDto> {
        val mutableList = mutableListOf<MealsDto>()
        MealsCategoriesForLean.entries.forEachIndexed { index, it ->
            mutableList.add(
                MealsDto(
                    mealsId = it.mealsId,
                    imageRes = it.imageRes,
                    mealsName = it.mealsName,
                    ingredients = it.ingredients,
                    calories = it.calories,
                    fats = it.fats,
                    protein = it.protein,
                    carbs = it.carbs,
                    mealTime = it.mealTime)
            )
        }
        return mutableList.toList().shuffled()
    }

    private fun generateMealsForAthletic(): List<MealsDto> {
        val mutableList = mutableListOf<MealsDto>()
        MealsCategoriesForAthletic.entries.forEachIndexed { index, it ->
            mutableList.add(
                MealsDto(
                    mealsId = it.mealsId,
                    imageRes = it.imageRes,
                    mealsName = it.mealsName,
                    ingredients = it.ingredients,
                    calories = it.calories,
                    fats = it.fats,
                    protein = it.protein,
                    carbs = it.carbs,
                    mealTime = it.mealTime)
            )
        }
        return mutableList.toList().shuffled()
    }

    private fun generateMealsForNatural(): List<MealsDto> {
        val mutableList = mutableListOf<MealsDto>()
        MealsCategoriesForNatural.entries.forEachIndexed { index, it ->
            mutableList.add(
                MealsDto(
                    mealsId = it.mealsId,
                    imageRes = it.imageRes,
                    mealsName = it.mealsName,
                    ingredients = it.ingredients,
                    calories = it.calories,
                    fats = it.fats,
                    protein = it.protein,
                    carbs = it.carbs,
                    mealTime = it.mealTime)
            )
        }
        return mutableList.toList().shuffled()
    }

}

