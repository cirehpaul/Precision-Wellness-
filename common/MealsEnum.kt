package com.example.fitness.common

import androidx.annotation.DrawableRes
import com.example.fitness.R



enum class MealTime(val label: String){
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
}

/********************************************************
 *  meals prep for [BodyFatLevel.LEAN]
 ********************************************************
 *  **/
enum class MealsCategoriesForLean(val mealsId: String,
                                  @DrawableRes val imageRes: Int,
                                  val mealsName: String,
                                  val ingredients: String,
                                  val mealTime: String,
                                  val fats: String,
                                  val protein: String,
                                  val carbs: String,
                                  val calories:  String) {

    /********************************************************
     *  meals prep for [BREAKFAST]
     ********************************************************
     *  **/
    Tuna(
        mealsId = "TUNA-01",
        imageRes = R.drawable.chicken_tocino_breakfast,
        mealsName = "Chicken Tocino Breakfast",
        ingredients = "A sweet and savory Filipino dish made with marinated chicken served with garlic rice and a fried egg.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "400",
        protein = "28g",
        carbs = "45g",
        fats = "15g"
    ),

    two(
        mealsId = "TUNA-02",
        imageRes = R.drawable.chickentinola_breakfast,
        mealsName = "Chicken Tinola",
        ingredients = "A comforting Filipino chicken soup made with ginger, green papaya, and chili leaves, often served with rice.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "350",
        protein = "30g",
        carbs = "35g",
        fats = "12g"
    ),

    three(
        mealsId = "TUNA-03",
        imageRes = R.drawable.inihawnababoybreakfast,
        mealsName = "Inihaw na Baboy (Grilled Pork)",
        ingredients = "Grilled marinated pork served with rice and a side of pickled vegetables, a staple Filipino dish.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "500",
        protein = "38g",
        carbs = "50g",
        fats = "20g"
    ),

    four(
        mealsId = "TUNA-04",
        imageRes = R.drawable.chicken_tocino_with_brown_rice_breakfast,
        mealsName = "Chicken Tocino with Brown Rice",
        ingredients = "A healthier version of chicken tocino served with nutritious brown rice, perfect for a hearty breakfast.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "450",
        protein = "30g",
        carbs = "55g",
        fats = "16g"
    ),

    five(
        mealsId = "TUNA-05",
        imageRes = R.drawable.fish_escabeche_breakfast,
        mealsName = "Fish Escabeche",
        ingredients = "A Filipino dish of fried fish in a sweet and sour sauce with vegetables, typically served with rice.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "400",
        protein = "30g",
        carbs = "40g",
        fats = "18g"
    ),

    six(
        mealsId = "TUNA-06",
        imageRes = R.drawable.grilled_chicken_inasal__breakfast,
        mealsName = "Grilled Chicken Inasal",
        ingredients = "A popular Visayan dish featuring marinated grilled chicken with a tangy and savory flavor.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "450",
        protein = "40g",
        carbs = "35g",
        fats = "18g"
    ),

    seven(
        mealsId = "TUNA-07",
        imageRes = R.drawable.pandesal_spread_with_creamy_peanut_butter_breakfast,
        mealsName = "Pandesal with Peanut Butter",
        ingredients = "A traditional Filipino breakfast with pandesal (soft bread rolls) spread with creamy peanut butter, a comforting and tasty treat.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "350",
        protein = "12g",
        carbs = "50g",
        fats = "15g"
    ),

    eight(
        mealsId = "TUNA-08",
        imageRes = R.drawable.paksiw_na_pata_breakfast,
        mealsName = "Paksiw na Pata",
        ingredients = "Pork hock simmered in vinegar, soy sauce, and spices, a hearty and tangy Filipino dish served with rice.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "600",
        protein = "40g",
        carbs = "35g",
        fats = "30g"
    ),

    nine(
        mealsId = "TUNA-09",
        imageRes = R.drawable.oatmeal_with_almond_milk__topped_with_bananas_and_chia_seeds_boiled_egg_breakfast,
        mealsName = "Oatmeal with Banana and Chia Seeds",
        ingredients = "A nutritious breakfast of oatmeal cooked with almond milk, topped with banana slices, chia seeds, and a boiled egg for added protein.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "350",
        protein = "18g",
        carbs = "45g",
        fats = "10g"
    ),

    ten(
        mealsId = "TUNA-10",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "Tuna Omelette",
        ingredients = "A protein-packed breakfast omelette made with tuna, eggs, and vegetables, perfect for a healthy start to the day.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "400",
        protein = "30g",
        carbs = "20g",
        fats = "25g"
    ),

    eleven(
        mealsId = "TUNA-11",
        imageRes = R.drawable.scrambled_eggs_made_with_3_eggs_breakfast,
        mealsName = "Scrambled Eggs",
        ingredients = "Scrambled eggs made with three eggs, a classic breakfast dish rich in protein.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "300",
        protein = "21g",
        carbs = "5g",
        fats = "22g"
    ),

    twelve(
        mealsId = "TUNA-12",
        imageRes = R.drawable.tinolang_manok__chicken_stew__breakfast,
        mealsName = "Tinolang Manok",
        ingredients = "A warm and soothing chicken stew with ginger, green papaya, and malunggay leaves.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "350",
        protein = "30g",
        carbs = "30g",
        fats = "10g"
    ),

    thirteen(
        mealsId = "TUNA-13",
        imageRes = R.drawable.sinigang_na_hipon_breakfast,
        mealsName = "Sinigang na Hipon (Shrimp Soup)",
        ingredients = "A tangy Filipino shrimp soup with a variety of vegetables, perfect for a light and healthy breakfast.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "250",
        protein = "20g",
        carbs = "25g",
        fats = "5g"
    ),

    fourteen(
        mealsId = "TUNA-14",
        imageRes = R.drawable.tinola_with_malunggay__chicken_tinola__breakfast,
        mealsName = "Chicken Tinola with Malunggay",
        ingredients = "A variation of chicken tinola with malunggay leaves, providing a healthy, nutrient-rich breakfast.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "300",
        protein = "30g",
        carbs = "35g",
        fats = "8g"
    ),

    fifteen(
        mealsId = "TUNA-15",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "Tuna Omelette",
        ingredients = "A quick and healthy breakfast omelette with tuna, vegetables, and eggs for a satisfying meal.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "400",
        protein = "30g",
        carbs = "20g",
        fats = "25g"
    ),
    /********************************************************
     *  meals prep for [LUNCH]
     ********************************************************
     *  **/
    EGGWITHRICE(
        mealsId = "MEALSBEGINNER-01",
        imageRes = R.drawable.egg_with_rice,
        mealsName = "Egg with Rice",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "190",
        protein = "15",
        fats = "10",
        carbs = "40"
    ),
    SINIGANG(
        mealsId = "MEALSBEGINNER-02",
        imageRes = R.drawable.sinigang,
        mealsName = "Sinigang na beef",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "170",
        protein = "26",
        fats = "15",
        carbs = "23"
    ),
    ADOBO(
        mealsId = "MEALSBEGINNER-03",
        imageRes = R.drawable.adobo,
        mealsName = "Adobo with Rice",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "125",
        protein = "30",
        fats = "25",
        carbs = "55"
    ),
    KAREKARE(
        mealsId = "MEALSBEGINNER-04",
        imageRes = R.drawable.kare_kare,
        mealsName = "Kare-Kare",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "123",
        protein = "35",
        fats = "15",
        carbs = "50"
    ),
    CHICKENTOCINO(
        mealsId = "MEALSBEGINNER-05",
        imageRes = R.drawable.chikentocino,
        mealsName = "Chicken Tocino",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "145",
        protein = "15",
        fats = "  15",
        carbs = "50"
    ),
    CHICKENTINOLA(
        mealsId = "MEALSBEGINNER-06",
        imageRes = R.drawable.chickentinola,
        mealsName = "Chicken Tinola",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "188 Kcal",
        protein = "21g",
        fats = "8g",
        carbs = "7g"
    ),
    SINIGANGNAPORK(
        mealsId = "MEALSBEGINNER-07",
        imageRes = R.drawable.sinigangpork,
        mealsName = "Sinigang na pork",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "160 Kcal",
        protein = "30g",
        fats = "25g",
        carbs = "55g"
    ),
    BISTEK(
        mealsId = "MEALSBEGINNER-08",
        imageRes = R.drawable.bistek_tagalog,
        mealsName = "Bistek Tagalog",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "160Kcal",
        protein = "35g",
        fats = "15g",
        carbs = "65g"
    ),
    LONGSILOG(
        mealsId = "MEALSBEGINNER-09",
        imageRes = R.drawable.longsilog,
        mealsName = "Longganisa Itlog",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "125 Kcal",
        protein = "25g",
        fats = "25g",
        carbs = "55g"
    ),
    SCRAMBLEEGGS(
        mealsId = "MEALSBEGINNER-10",
        imageRes = R.drawable.scrambleeggs,
        mealsName = "Scramble Eggs",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "80 Kcal",
        protein = "28g",
        fats = "25g",
        carbs = "40g"
    ),

    /********************************************************
     *  meals prep for [DINNER]
     ********************************************************
     *  **/
    dawd(
        mealsId = "1",
        imageRes = R.drawable.beef_caldereta_dinner,
        mealsName = "Beef Caldereta",
        ingredients = "A hearty Filipino beef stew cooked in tomato sauce with vegetables, including potatoes, carrots, and bell peppers.",
        mealTime = MealTime.DINNER.label,
        calories = "450 Kcal",
        protein = "35g",
        carbs = "25g",
        fats = "25g"
    ),
    tawdawwo(
        mealsId = "2",
        imageRes = R.drawable.chicken_adobo_dinner,
        mealsName = "Chicken Adobo",
        ingredients = "A classic Filipino dish made with chicken, soy sauce, vinegar, and garlic, simmered until tender and flavorful.",
        mealTime = MealTime.DINNER.label,
        calories = "400 Kcal",
        protein = "30g",
        carbs = "12g",
        fats = "22g"
    ),
    wda(
        mealsId = "3",
        imageRes = R.drawable.chicken_adobo_dinner,
        mealsName = "Chicken Adobo",
        ingredients = "A rich and savory chicken dish braised in vinegar, soy sauce, garlic, and bay leaves.",
        mealTime = MealTime.DINNER.label,
        calories = "410 Kcal",
        protein = "32g",
        carbs = "15g",
        fats = "18g"
    ),
    fowdaur(
        mealsId = "4",
        imageRes = R.drawable.pinakbet_dinner,
        mealsName = "Pinakbet",
        ingredients = "A vegetable dish from the Philippines made with squash, eggplant, string beans, and okra, flavored with shrimp paste.",
        mealTime = MealTime.DINNER.label,
        calories = "200 Kcal",
        protein = "5g",
        carbs = "30g",
        fats = "10g"
    ),
    fivawdwae(
        mealsId = "5",
        imageRes = R.drawable.chicken_caldereta_dinner,
        mealsName = "Chicken Caldereta",
        ingredients = "A rich Filipino chicken stew cooked with tomato sauce, liver spread, and vegetables like potatoes and carrots.",
        mealTime = MealTime.DINNER.label,
        calories = "420 Kcal",
        protein = "38g",
        carbs = "20g",
        fats = "18g"
    ),
    siawdx(
        mealsId = "6",
        imageRes = R.drawable.bangus_belly_sinigang_dinner,
        mealsName = "Bangus Belly Sinigang",
        ingredients = "A sour soup made with bangus (milkfish), tamarind, and vegetables like kangkong and radish.",
        mealTime = MealTime.DINNER.label,
        calories = "350 Kcal",
        protein = "30g",
        carbs = "18g",
        fats = "20g"
    ),
    sewadven(
        mealsId = "7",
        imageRes = R.drawable.grilled_bangus_dinner,
        mealsName = "Grilled Bangus",
        ingredients = "A grilled milkfish marinated in spices and served with a side of tomatoes and onions.",
        mealTime = MealTime.DINNER.label,
        calories = "370 Kcal",
        protein = "28g",
        carbs = "5g",
        fats = "25g"
    ),
    eiwdght(
        mealsId = "8",
        imageRes = R.drawable.grilled_tilapia_w_spinach_dinner,
        mealsName = "Grilled Tilapia with Spinach",
        ingredients = "Grilled tilapia served with a side of sautéed spinach, creating a healthy and flavorful meal.",
        mealTime = MealTime.DINNER.label,
        calories = "300 Kcal",
        protein = "30g",
        carbs = "10g",
        fats = "15g"
    ),
    niawdne(
        mealsId = "9",
        imageRes = R.drawable.pork_binagoongan_dinner,
        mealsName = "Pork Binagoongan",
        ingredients = "Pork cooked in shrimp paste with eggplant and other vegetables, creating a savory and spicy dish.",
        mealTime = MealTime.DINNER.label,
        calories = "450 Kcal",
        protein = "28g",
        carbs = "20g",
        fats = "30g"
    ),
    teawdn(
        mealsId = "10",
        imageRes = R.drawable.chicken_tocino_dinner,
        mealsName = "Chicken Tocino",
        ingredients = "A sweet and savory Filipino dish made with chicken marinated in sugar, salt, and garlic, then fried.",
        mealTime = MealTime.DINNER.label,
        calories = "400 Kcal",
        protein = "30g",
        carbs = "12g",
        fats = "25g"
    ),
    elawdeven(
        mealsId = "11",
        imageRes = R.drawable.tuna_omellete_with_mango_dinner,
        mealsName = "Tuna Omelette with Mango",
        ingredients = "A delicious and light dinner option of tuna omelette served with fresh mango for a sweet contrast.",
        mealTime = MealTime.DINNER.label,
        calories = "350 Kcal",
        protein = "32g",
        carbs = "15g",
        fats = "18g"
    ),
    twawdelve(
        mealsId = "12",
        imageRes = R.drawable.pandesal_with_peanut_and_papaya_dinner,
        mealsName = "Pandesal with Peanut and Papaya",
        ingredients = "A Filipino dinner of soft pandesal bread served with peanut spread and fresh papaya.",
        mealTime = MealTime.DINNER.label,
        calories = "280 Kcal",
        protein = "8g",
        carbs = "35g",
        fats = "15g"
    ),
    thiawdrteen(
        mealsId = "13",
        imageRes = R.drawable.tuna_pandesal_dinner,
        mealsName = "Tuna Pandesal",
        ingredients = "A tasty snack or light dinner of pandesal stuffed with tuna, served with a side of salad.",
        mealTime = MealTime.DINNER.label,
        calories = "350 Kcal",
        protein = "25g",
        carbs = "30g",
        fats = "12g"
    ),
    fouadwadrteen(
        mealsId = "14",
        imageRes = R.drawable.pork_nilaga_with_cucumber_dinner,
        mealsName = "Pork Nilaga with Cucumber",
        ingredients = "A light and comforting pork soup served with fresh cucumber slices for added crunch.",
        mealTime = MealTime.DINNER.label,
        calories = "380 Kcal",
        protein = "30g",
        carbs = "20g",
        fats = "18g"
    ),
    fivwdeteen(
        mealsId = "15",
        imageRes = R.drawable.tuna__dinner,
        mealsName = "Grilled Tuna",
        ingredients = "Grilled tuna steaks seasoned with herbs and served with a side of mixed vegetables.",
        mealTime = MealTime.DINNER.label,
        calories = "400 Kcal",
        protein = "35g",
        carbs = "10g",
        fats = "22g"
    )
}

    /********************************************************
 *  meals prep for [BodyFatLevel.ATHLETIC]
 ********************************************************
 *  **/
enum class MealsCategoriesForAthletic(val mealsId: String,
                                      @DrawableRes val imageRes: Int,
                                      val mealsName: String,
                                      val ingredients: String,
                                      val mealTime: String,
                                      val fats: String,
                                      val protein: String,
                                      val carbs: String,
                                      val calories:  String) {

        /********************************************************
         *  meals prep for [BREAKFAST]
         ********************************************************
         *  **/
        Tuna(
            mealsId = "TUNA-01",
            imageRes = R.drawable.chicken_tocino_breakfast,
            mealsName = "Chicken Tocino",
            ingredients = "Prepare the Tocino:\n" +
                    "\n" +
                    "Place the tocino in a frying pan. If it's frozen, let it thaw first.\n" +
                    "Simmer:\n" +
                    "\n" +
                    "Add enough water to the pan to cover the tocino halfway.\n" +
                    "Heat the pan over medium heat and bring the water to a gentle boil. This step ensures the meat cooks thoroughly.\n" +
                    "Cook Until Water Evaporates:\n" +
                    "\n" +
                    "Allow the water to evaporate completely, stirring occasionally to prevent sticking.\n" +
                    "Pan-Fry:\n" +
                    "\n" +
                    "Once the water is gone, let the tocino render its fat. If it doesn’t release enough fat for frying, add a small amount of cooking oil.\n" +
                    "Fry the tocino over medium-low heat until it caramelizes, flipping occasionally to prevent burning.\n" +
                    "Serve:\n" +
                    "\n" +
                    "Once the tocino is cooked and nicely browned, remove it from the pan and serve hot.",
            mealTime = MealTime.BREAKFAST.label,
            calories = "350 Kcal",
            protein = "22 g",
            carbs = "25 g",
            fats = "18 g"
        ),
        two(
            mealsId = "MEAL-02",
            imageRes = R.drawable.chickentinola_breakfast,
            mealsName = "Chicken Tinola ",
            ingredients = "Sauté Aromatics:\n" +
                    "\n" +
                    "Heat cooking oil in a pot over medium heat.\n" +
                    "Sauté the ginger, garlic, and onion until fragrant and the onions become translucent.\n" +
                    "Cook the Chicken:\n" +
                    "\n" +
                    "Add the chicken pieces and cook for about 5-7 minutes, stirring occasionally, until the chicken turns lightly golden.\n" +
                    "Season:\n" +
                    "\n" +
                    "Pour in the fish sauce and stir to coat the chicken. Let it cook for 1-2 minutes to absorb the flavor.\n" +
                    "Add Water/Stock:\n" +
                    "\n" +
                    "Pour in the water or chicken stock. Bring it to a boil, then reduce the heat to simmer.\n" +
                    "Simmer Until Tender:\n" +
                    "\n" +
                    "Cover the pot and let the chicken cook for about 25-30 minutes, or until tender.\n" +
                    "Add Vegetables:\n" +
                    "\n" +
                    "Add the green papaya or chayote and simmer for another 5-7 minutes, or until the vegetables are tender.\n" +
                    "Add Greens:\n" +
                    "\n" +
                    "Stir in the malunggay leaves (or spinach) and cook for an additional 1-2 minutes until wilted.\n" +
                    "Taste and Adjust:\n" +
                    "\n" +
                    "Season with salt and pepper to taste.\n" +
                    "Serve Hot:\n" +
                    "\n" +
                    "Ladle the soup into bowls and serve with steamed rice.",
            mealTime = MealTime.BREAKFAST.label,
            calories = "320 Kcal",
            protein = "28g",
            carbs = "24g",
            fats = "10g"
        ),
        three(
            mealsId = "MEAL-03",
            imageRes = R.drawable.inihawnababoybreakfast,
            mealsName = "Inihaw na Baboy ",
            ingredients = "Prepare the Pork:\n" +
                    "\n" +
                    "Slice the pork belly into thin, grill-friendly pieces. If using skewers, cut them into bite-sized cubes and soak the skewers in water for 30 minutes to prevent burning.\n" +
                    "Make the Marinade:\n" +
                    "\n" +
                    "Combine soy sauce, calamansi juice, banana ketchup, brown sugar, garlic, black pepper, and chili (if using) in a bowl. Mix well.\n" +
                    "Reserve a small portion of the marinade for the basting sauce.\n" +
                    "Marinate the Pork:\n" +
                    "\n" +
                    "Add the pork to the marinade, ensuring it’s well-coated. Cover and let it marinate in the refrigerator for at least 2 hours, preferably overnight for best flavor.\n" +
                    "Prepare the Basting Sauce:\n" +
                    "\n" +
                    "Mix the reserved marinade with cooking oil and banana ketchup in a small bowl. Set aside.\n" +
                    "Preheat the Grill:\n" +
                    "\n" +
                    "Heat a charcoal or gas grill to medium heat.\n" +
                    "Grill the Pork:\n" +
                    "\n" +
                    "Place the pork on the grill. If using skewers, thread the pork onto them before grilling.\n" +
                    "Grill for 4-5 minutes per side, basting with the sauce occasionally, until the pork is fully cooked and has a nice char.\n" +
                    "Serve:\n" +
                    "\n" +
                    "Remove the pork from the grill and let it rest for a few minutes.\n" +
                    "Serve hot with steamed rice and dipping sauces like toyomansi (soy sauce and calamansi) or vinegar with chopped onions and chili.",
            mealTime = MealTime.BREAKFAST.label,
            calories = "450 Kcal",
            protein = "30g",
            carbs = "20g",
            fats = "30g"
        ),
        four(
            mealsId = "MEAL-04",
            imageRes = R.drawable.chicken_tocino_with_brown_rice_breakfast,
            mealsName = "Chicken Tocino with Brown Rice",
            ingredients = "Prepare the Chicken Tocino:\n" +
                    "Marinate the Chicken:\n" +
                    "\n" +
                    "In a bowl, combine pineapple juice, brown sugar, soy sauce, vinegar, salt, paprika, garlic, and optional food coloring. Mix well.\n" +
                    "Add the chicken slices to the marinade, ensuring they’re fully coated. Cover and refrigerate for at least 4 hours or overnight for best results.\n" +
                    "Cook the Chicken Tocino:\n" +
                    "\n" +
                    "Heat a non-stick pan over medium heat.\n" +
                    "Place the marinated chicken in the pan and add 1/4 cup of water.\n" +
                    "Simmer until the water evaporates and the chicken cooks through.\n" +
                    "Once the water is gone, let the chicken render its fat. If needed, add a small amount of oil to fry the chicken until caramelized and slightly charred.\n" +
                    "Prepare the Brown Rice:\n" +
                    "Cook Brown Rice:\n" +
                    "Rinse 1 cup of brown rice under cold water.\n" +
                    "Combine it with 2 cups of water in a rice cooker or pot.\n" +
                    "Cook until tender, fluff with a fork, and keep warm.\n" +
                    "Assemble the Dish:\n" +
                    "Plate a serving of brown rice.\n" +
                    "Add the caramelized chicken tocino on the side.\n" +
                    "Optional: Top with a fried egg and garnish with sliced tomatoes or atchara.\n",
            mealTime = MealTime.BREAKFAST.label,
            calories = "380 Kcal",
            protein = "25g",
            carbs = "28g",
            fats = "15g"
        ),
        five(
            mealsId = "MEAL-05",
            imageRes = R.drawable.fish_escabeche_breakfast,
            mealsName = "Fish Escabeche ",
            ingredients ="Prepare the Fish:\n" +
                    "Season the Fish:\n" +
                    "\n" +
                    "Pat the fish dry with paper towels and season with salt and pepper on both sides.\n" +
                    "Fry the Fish:\n" +
                    "\n" +
                    "Heat oil in a frying pan over medium heat.\n" +
                    "Lightly dredge the fish in flour, shaking off excess.\n" +
                    "Fry the fish in the hot oil until golden and crispy, about 5-7 minutes per side (depending on the size of the fish).\n" +
                    "Once fried, drain the fish on paper towels to remove excess oil.\n" +
                    "Make the Escabeche Sauce:\n" +
                    "Prepare the Sauce:\n" +
                    "\n" +
                    "In a separate pan, combine the vinegar, sugar, water, soy sauce (if using), salt, and pepper. Bring to a simmer over medium heat.\n" +
                    "Add the garlic, ginger, onion, carrot, and bell pepper. Let the mixture simmer for about 5-7 minutes until the vegetables are tender but still slightly crisp.\n" +
                    "Thicken the Sauce (Optional):\n" +
                    "\n" +
                    "If you prefer a thicker sauce, dissolve 1 teaspoon of cornstarch in a small amount of water and add it to the pan. Stir well until the sauce thickens slightly.\n" +
                    "Assemble the Dish:\n" +
                    "Serve the Fish:\n" +
                    "\n" +
                    "Arrange the fried fish on a serving platter.\n" +
                    "Pour the escabeche sauce and vegetables over the fish, ensuring it’s well-coated.\n" +
                    "Garnish and Serve:\n" +
                    "\n" +
                    "Serve immediately with steamed rice.",
            mealTime = MealTime.BREAKFAST.label,
            calories = "340 Kcal",
            protein = "30g",
            carbs = "25g",
            fats = "10g"
        ),
        six(
            mealsId = "MEAL-06",
            imageRes = R.drawable.grilled_chicken_inasal__breakfast,
            mealsName = "Grilled Chicken Inasal ",
            ingredients = "Prepare the Annatto Oil:\n" +
                    "Make the Annatto Oil:\n" +
                    "Heat the vegetable oil in a small pan over low heat.\n" +
                    "Add the annatto seeds to the oil and let them simmer for about 3-5 minutes, stirring occasionally, until the oil turns a bright orange color. If using annatto powder, simply stir it into the oil.\n" +
                    "Remove from heat and strain the oil to remove the seeds. Set the oil aside.\n" +
                    "Marinate the Chicken:\n" +
                    "Marinate the Chicken:\n" +
                    "In a large bowl, combine the soy sauce, vinegar, calamansi juice, brown sugar, garlic, onion, ginger, chili, salt, pepper, turmeric, and paprika.\n" +
                    "Add the chicken pieces and massage the marinade into the chicken.\n" +
                    "Cover the bowl and refrigerate for at least 2 hours, preferably overnight for more flavor.\n" +
                    "Grill the Chicken:\n" +
                    "Preheat the Grill:\n" +
                    "\n" +
                    "Preheat your charcoal or gas grill to medium-high heat. If you’re using banana leaves, line the grill with them to give the chicken an added flavor.\n" +
                    "Grill the Chicken:\n" +
                    "\n" +
                    "Place the marinated chicken on the grill and cook for 10-12 minutes per side, or until the chicken is fully cooked and slightly charred. Baste the chicken with the annatto oil while grilling to enhance the flavor and color.\n" +
                    "Flip the chicken occasionally to avoid burning and ensure even cooking.\n" +
                    "Serve:\n" +
                    "Garnish and Serve:\n" +
                    "Once grilled, serve the chicken with a squeeze of lime or calamansi on top.\n" +
                    "Serve with steamed rice and a side of dipping sauce (such as toyomansi - a mixture of soy sauce and calamansi, or vinegar with garlic and chili).",
            mealTime = MealTime.BREAKFAST.label,
            calories = "300 Kcal",
            protein = "32g",
            carbs = "20g",
            fats = "8g"
        ),
        seven(
            mealsId = "MEAL-07",
            imageRes = R.drawable.pandesal_spread_with_creamy_peanut_butter_breakfast,
            mealsName = "Pandesal with Peanut Butter",
            ingredients = "Making Pandesal (from scratch):\n" +
                    "Activate the Yeast:\n" +
                    "\n" +
                    "In a bowl, combine the warm milk (or water) and sugar. Sprinkle the yeast over the top and stir gently. Let it sit for about 5-10 minutes until frothy.\n" +
                    "Make the Dough:\n" +
                    "\n" +
                    "In a large mixing bowl, combine the flour and salt. Add the activated yeast mixture, vegetable oil, and egg (if using).\n" +
                    "Mix until the dough forms a ball. Knead for about 8-10 minutes until smooth and elastic. If it's too sticky, add a little flour at a time.\n" +
                    "Let the Dough Rise:\n" +
                    "\n" +
                    "Place the dough in a lightly greased bowl, cover it with a clean kitchen towel, and let it rise for about 1-1.5 hours, or until doubled in size.\n" +
                    "Shape the Pandesal:\n" +
                    "\n" +
                    "Once the dough has risen, punch it down to release air. Divide the dough into small portions, about 1.5 oz (45 g) each, and shape into round balls.\n" +
                    "Roll each dough ball in breadcrumbs to coat it.\n" +
                    "Second Rise:\n" +
                    "\n" +
                    "Place the dough balls on a baking sheet, leaving some space between them. Cover and let them rise for another 30 minutes.\n" +
                    "Bake:\n" +
                    "\n" +
                    "Preheat your oven to 375°F (190°C). Bake the pandesal for about 15-18 minutes, or until golden brown on top.\n" +
                    "Cool:\n" +
                    "\n" +
                    "Once done, remove the pandesal from the oven and let them cool on a wire rack.",
            mealTime = MealTime.BREAKFAST.label,
            calories = "250 Kcal",
            protein = "8g",
            carbs = "30g",
            fats = "10g"
        ),
        eight(
            mealsId = "MEAL-08",
            imageRes = R.drawable.paksiw_na_pata_breakfast,
            mealsName = "Paksiw na Pata",
            ingredients = "Prepare the Pork:\n" +
                    "Blanch the Pork:\n" +
                    "In a large pot, add the pork hock pieces and enough water to cover the meat. Bring it to a boil and let it cook for about 5 minutes to remove any impurities. Drain and discard the water.\n" +
                    "Cook the Paksiw:\n" +
                    "Sauté Aromatics:\n" +
                    "\n" +
                    "Heat oil in a large pot or Dutch oven over medium heat.\n" +
                    "Sauté the garlic and onion until fragrant and the onions become translucent.\n" +
                    "Add Pork and Seasonings:\n" +
                    "\n" +
                    "Add the blanched pork hock to the pot, then pour in the soy sauce, vinegar, and water. Stir to combine.\n" +
                    "Add the bay leaves, peppercorns, and fish sauce (if using). Bring to a boil and then lower the heat to a simmer.\n" +
                    "Simmer Until Tender:\n" +
                    "\n" +
                    "Let the pork simmer for about 1.5 to 2 hours, or until the meat becomes tender and easy to shred. If needed, add more water as it simmers.\n" +
                    "Add the Vegetables (Optional):\n" +
                    "\n" +
                    "Add the potato and carrot slices, then continue to simmer until the vegetables are tender, about 10-15 minutes.\n" +
                    "Add Sweetness and Adjust Seasoning:\n" +
                    "\n" +
                    "Stir in the brown sugar and taste for seasoning. You may need to adjust the salt or pepper to your liking. Continue simmering for another 5 minutes.\n" +
                    "Final Taste Check:\n" +
                    "\n" +
                    "If the sauce is too tangy for your liking, you can add a bit more sugar to balance the flavors. If it’s too thick, you can add a bit of water or broth.",
            mealTime = MealTime.BREAKFAST.label,
            calories = "420 Kcal",
            protein = "20g",
            carbs = "30g",
            fats = "25g"
        ),
        nine(
            mealsId = "MEAL-09",
            imageRes = R.drawable.oatmeal_with_almond_milk__topped_with_bananas_and_chia_seeds_boiled_egg_breakfast,
            mealsName ="Cook the Oats:\n" +
                    "\n" +
                    "In a medium saucepan, bring the water or milk to a boil. Once boiling, reduce the heat to low and add the oats.\n" +
                    "Stir occasionally and cook for about 5-7 minutes (for rolled oats) or 2-3 minutes (for quick oats), until the oats are soft and the liquid is absorbed. If you prefer a creamier texture, you can cook a little longer and add extra milk.\n" +
                    "Add the Banana and Chia Seeds:\n" +
                    "\n" +
                    "While the oats are still hot, stir in the chia seeds, banana slices, and cinnamon (if using). The chia seeds will absorb some of the liquid and thicken the oatmeal slightly, while the banana will soften and sweeten the dish naturally.\n" +
                    "Sweeten (Optional):\n" +
                    "\n" +
                    "If you like your oatmeal sweeter, drizzle in honey or maple syrup, then stir well.\n" +
                    "Serve:\n" +
                    "\n" +
                    "Once the oatmeal has reached your desired consistency, transfer it to a bowl and add your favorite toppings, such as extra banana slices, a handful of nuts, or a sprinkle of granola for crunch.",
            ingredients = "",
            mealTime = MealTime.BREAKFAST.label,
            calories = "280 Kcal",
            protein = "12g",
            carbs = "35g",
            fats = "8g"
        ),
        ten(
            mealsId = "MEAL-10",
            imageRes = R.drawable.tuna_omelette,
            mealsName = "Tuna Omelette ",
            ingredients  = "Cook the Oats:\n" +
                    "\n" +
                    "In a medium saucepan, bring the water or milk to a boil. Once boiling, reduce the heat to low and add the oats.\n" +
                    "Stir occasionally and cook for about 5-7 minutes (for rolled oats) or 2-3 minutes (for quick oats), until the oats are soft and the liquid is absorbed. If you prefer a creamier texture, you can cook a little longer and add extra milk.\n" +
                    "Add the Banana and Chia Seeds:\n" +
                    "\n" +
                    "While the oats are still hot, stir in the chia seeds, banana slices, and cinnamon (if using). The chia seeds will absorb some of the liquid and thicken the oatmeal slightly, while the banana will soften and sweeten the dish naturally.\n" +
                    "Sweeten (Optional):\n" +
                    "\n" +
                    "If you like your oatmeal sweeter, drizzle in honey or maple syrup, then stir well.\n" +
                    "Serve:\n" +
                    "\n" +
                    "Once the oatmeal has reached your desired consistency, transfer it to a bowl and add your favorite toppings, such as extra banana slices, a handful of nuts, or a sprinkle of granola for crunch.",
            mealTime = MealTime.BREAKFAST.label,
            calories = "360 Kcal",
            protein = "30g",
            carbs = "20g",
            fats = "15g"
        ),
        eleven(
            mealsId = "MEAL-11",
            imageRes = R.drawable.scrambled_eggs_made_with_3_eggs_breakfast,
            mealsName = "Scrambled Eggs ",
            ingredients = "3 large eggs\n" +
                    "1-2 tbsp butter (or oil, for a lighter version)\n" +
                    "Salt, to taste\n" +
                    "Pepper, to taste\n" +
                    "1-2 tbsp milk or cream (optional, for creaminess)\n" +
                    "Instructions\n" +
                    "Prepare the Eggs:\n" +
                    "\n" +
                    "Crack the eggs into a bowl. Add a pinch of salt and pepper. If you want creamier eggs, add 1-2 tablespoons of milk or cream. Whisk the eggs thoroughly until the yolks and whites are fully combined, and the mixture is slightly frothy.\n" +
                    "Heat the Pan:\n" +
                    "\n" +
                    "Heat a non-stick skillet over medium-low to medium heat. Add the butter (or oil) and let it melt completely, swirling the pan to coat the bottom.\n" +
                    "Cook the Scrambled Eggs:\n" +
                    "\n" +
                    "Pour the beaten eggs into the pan. Allow the eggs to sit undisturbed for a few seconds, then gently stir with a spatula, pushing the eggs from the edges to the center. This will form soft curds.\n" +
                    "Continue stirring occasionally, letting the eggs cook in intervals. You want the eggs to cook slowly and gently, not over high heat, to keep them soft and creamy.\n" +
                    "Finish Cooking:\n" +
                    "\n" +
                    "Once the eggs are mostly set but still slightly runny, remove the pan from the heat. The residual heat will finish cooking them, leaving them soft and creamy.\n" +
                    "Serve:\n" +
                    "\n" +
                    "Transfer the scrambled eggs to a plate immediately. You can garnish with fresh herbs like chives, parsley, or a sprinkle of cheese, if desired.",
            mealTime = MealTime.BREAKFAST.label,
            calories = "240 Kcal",
            protein = "18g",
            carbs = "12g",
            fats = "15g"
        ),
        twelve(
            mealsId = "MEAL-12",
            imageRes = R.drawable.tinolang_manok__chicken_stew__breakfast,
            mealsName = "Chicken Tinola ",
            ingredients ="Sauté Aromatics:\n" +
                    "Heat the oil in a large pot over medium heat. Sauté the onions and ginger for about 2-3 minutes until fragrant and softened.\n" +
                    "Cook the Chicken:\n" +
                    "\n" +
                    "Add the chicken pieces to the pot and cook for about 5 minutes, stirring occasionally, until the chicken is lightly browned on all sides.\n" +
                    "Add Seasonings and Broth:\n" +
                    "\n" +
                    "Add the fish sauce and stir. Pour in the water or chicken broth, then bring it to a boil. Skim off any impurities that float to the top.\n" +
                    "Add the lemongrass stalks (if using) and simmer for about 30-40 minutes, or until the chicken is cooked through and tender.\n" +
                    "Add the Papaya or Chayote:\n" +
                    "\n" +
                    "Once the chicken is tender, add the papaya or chayote chunks to the pot. Let it simmer for about 10-15 minutes until the vegetables are soft.\n" +
                    "Add the Leaves:\n" +
                    "\n" +
                    "Add the chili leaves or malunggay leaves. Cook for an additional 2-3 minutes until the leaves are tender.\n" +
                    "Season and Adjust:\n" +
                    "\n" +
                    "Season the soup with salt and pepper to taste. Remove the lemongrass stalks (if used) before serving.\n" +
                    "Serve:\n" +
                    "\n" +
                    "Serve the Chicken Tinola hot with steamed rice on the side. Enjoy the comforting, aromatic soup!",
            mealTime = MealTime.BREAKFAST.label,
            calories = "320 Kcal",
            protein = "28g",
            carbs = "24g",
            fats = "10g"
        )
,


        /********************************************************
         *  meals prep for [LUNCH]
         ********************************************************
         *  **/
        TUNAPANDESAL(
            mealsId = "MEALSINTERMEDIATE-01",
            imageRes = R.drawable.tuna_pandesal,
            mealsName = "Tuna Pandesal",
            ingredients = "For the Tuna Filling:\n" +
                    "1 can (160g) tuna in oil or water, drained and flaked\n" +
                    "1/4 cup mayonnaise\n" +
                    "1 tbsp Dijon mustard or regular mustard (optional, for extra tang)\n" +
                    "1/4 onion, finely chopped\n" +
                    "1 small tomato, diced (optional)\n" +
                    "Salt and pepper, to taste\n" +
                    "1-2 tbsp pickles or relish (optional)\n" +
                    "1/4 cup grated cheese (optional)\n" +
                    "For the Pandesal:\n" +
                    "4-6 pieces of pandesal (store-bought or homemade, depending on preference)\n" +
                    "Instructions\n" +
                    "Make the Tuna Filling:\n" +
                    "Prepare the Tuna:\n" +
                    "\n" +
                    "In a bowl, combine the flaked tuna with mayonnaise, mustard (if using), and pickles or relish (if desired). Stir well to combine.\n" +
                    "Add Vegetables:\n" +
                    "\n" +
                    "Mix in the finely chopped onion and diced tomato for added flavor and crunch. Season with salt and pepper to taste.\n" +
                    "Optional Cheese:\n" +
                    "\n" +
                    "For a richer filling, you can mix in some grated cheese to the tuna mixture, which will melt and add a creamy texture when heated.\n" +
                    "Assemble the Tuna Pandesal:\n" +
                    "Prepare the Pandesal:\n" +
                    "\n" +
                    "If using store-bought pandesal, slice each roll in half horizontally. If making homemade pandesal, you can slice the freshly baked rolls.\n" +
                    "Fill the Pandesal:\n" +
                    "\n" +
                    "Spoon the tuna mixture generously onto the bottom half of each pandesal roll. Top with the other half of the roll to close.\n" +
                    "Optional: Toast the Pandesal:\n" +
                    "\n" +
                    "You can lightly toast the filled pandesal in a hot skillet or on a griddle for 2-3 minutes on each side until golden brown. This will add a nice crunch to the bread.\n" +
                    "Serve:\n" +
                    "Enjoy the Tuna Pandesal:\n" +
                    "Serve the Tuna Pandesal warm or at room temperature. It's perfect for breakfast, lunch, or as a snack with a hot cup of coffee or tea.",
            mealTime = MealTime.LUNCH.label,
            calories = "59 Kcal ",
            protein = "15g",
            fats = "10g",
            carbs = "40g"
        ),
        SINIGANG(
            mealsId = "MEALSINTERMEDIATE-02",
            imageRes = R.drawable.grilled_tilapia,
            mealsName = "Sinigang na beef",
            ingredients =  "Prepare the Beef:\n" +
                    "\n" +
                    "In a large pot, heat the vegetable oil over medium heat. Add the beef pieces and cook until lightly browned on all sides.\n" +
                    "Sauté the Aromatics:\n" +
                    "\n" +
                    "Add the quartered onions and tomatoes to the pot. Stir and cook for about 5 minutes, or until the tomatoes soften and release their juice.\n" +
                    "Add Water or Broth:\n" +
                    "\n" +
                    "Pour in the water or beef broth and bring it to a boil. Skim off any impurities or foam that rises to the surface. Once it boils, lower the heat and let it simmer for about 1.5 to 2 hours, or until the beef becomes tender.\n" +
                    "Add Tamarind and Seasonings:\n" +
                    "\n" +
                    "Add the tamarind paste (or sinigang mix), fish sauce, and green chili peppers (if using). Stir to dissolve the tamarind paste and adjust the seasoning to your liking. You can add more fish sauce for saltiness or tamarind for extra sourness.\n" +
                    "Add the Vegetables:\n" +
                    "\n" +
                    "Once the beef is tender, add the sliced radish, eggplants, and potatoes (if using). Continue to simmer for about 10 minutes until the vegetables are cooked through.\n" +
                    "Finish with Greens:\n" +
                    "\n" +
                    "Add the string beans and kangkong (or other leafy greens) last. Simmer for another 2-3 minutes until the greens are tender.\n" +
                    "Season to Taste:\n" +
                    "\n" +
                    "Taste the broth and adjust the seasoning with salt and pepper, if needed. If you prefer more sourness, you can add more tamarind paste or a squeeze of fresh calamansi or lime juice.\n" +
                    "Serve:\n" +
                    "\n" +
                    "Ladle the Sinigang na Beef into bowls and serve with steamed rice on the side. Enjoy the sour, savory, and flavorful broth with the tender beef and vegetables.",
            mealTime = MealTime.LUNCH.label,
            calories = "189 Kcal",
            protein = "26",
            fats = "15",
            carbs = "23"
        ),
        ADOBO(
            mealsId = "MEALSINTERMEDIATE-03",
            imageRes = R.drawable.chicken_adobo,
            mealsName = "Adobo with Rice",
            ingredients =  "Marinate the Meat:\n" +
                    "In a bowl, combine the chicken or pork with soy sauce, vinegar, garlic, onion, bay leaves, and peppercorns. Mix well and marinate for at least 30 minutes, or preferably for a few hours to allow the flavors to develop.\n" +
                    " Cook the Rice:\n" +
                    "While the meat is marinating, rinse the rice thoroughly under cold water to remove excess starch. Place the rice in a rice cooker with 4 cups of water. Cook according to your rice cooker's instructions. Alternatively, you can cook the rice in a pot by bringing it to a boil, then lowering the heat, covering, and simmering for about 15-20 minutes until the rice is fully cooked.\n" +
                    " Cook the Adobo:\n" +
                    "Heat oil in a large pan over medium heat. Once hot, add the marinated meat (without the marinade) and brown it on all sides. This will help develop deeper flavors in the dish.\n" +
                    "Once the meat is browned, add the marinade, including the garlic, onions, and bay leaves. Stir to combine.\n" +
                    "Add 1 cup of water to the pan, bring to a boil, then reduce the heat to low and simmer for 30-40 minutes, or until the meat is tender and the sauce has reduced to your desired consistency.\n" +
                    "If you prefer a sweeter adobo, you can add 1 tablespoon of brown sugar during the simmering process. Taste and adjust seasoning with salt and pepper as needed.\n" +
                    " Serve:\n" +
                    "Once the adobo is ready, serve it hot with a generous portion of steamed white rice. Spoon the adobo sauce over the rice to allow the flavors to soak in.",
            mealTime = MealTime.LUNCH.label,
            calories = "170 Kcal",
            protein = "30g",
            fats = "25g",
            carbs = "55g"
        ),
        CHICKENINSAL(
            mealsId = "MEALSINTERMEDIATE-04",
            imageRes = R.drawable.chicken_inasal,
            mealsName = "Chiken Inasal",
            ingredients =   " Marinate the Chicken:\n" +
                    "In a large bowl, combine the vinegar, soy sauce, calamansi juice, minced garlic, chopped lemongrass, brown sugar, salt, and black pepper. Stir well until the sugar dissolves.\n" +
                    "Add the chicken parts into the marinade, making sure the chicken is well-coated. Cover and let it marinate for at least 1 hour, or up to 3 hours in the refrigerator to allow the flavors to soak in.\n" +
                    " Prepare the Basting Sauce:\n" +
                    "In a small bowl, mix the annatto oil (or regular oil with annatto powder), butter (optional), soy sauce, vinegar, and sugar. Stir until combined and set aside. This will be used to baste the chicken while grilling.\n" +
                    " Grill the Chicken:\n" +
                    "Preheat your grill or barbecue to medium heat. If you're using banana leaves, you can place them on the grill grates to prevent the chicken from sticking.\n" +
                    "Once the grill is hot, place the marinated chicken on the grill. Cook the chicken for about 25-30 minutes, turning every 5-7 minutes to ensure even grilling and prevent burning.\n" +
                    "While grilling, baste the chicken with the prepared basting sauce every few minutes to keep it moist and add flavor.\n" +
                    "Grill the chicken until it’s fully cooked and has a nice golden-brown char on the outside. The internal temperature of the chicken should reach 75°C (165°F).\n" +
                    " Serve:\n" +
                    "Remove the chicken from the grill and let it rest for a few minutes before serving.\n" +
                    "Serve your Chicken Inasal with steamed white rice and the dipping sauce on the side for added flavor.\n",
            mealTime = MealTime.LUNCH.label,
            calories = "125 Kcal",
            protein = "35g",
            fats = "15g",
            carbs = "50g"
        ),
        CHICKENTOCINO(
            mealsId = "MEALSINTERMEDIATE-05",
            imageRes = R.drawable.chikentocino,
            mealsName = "Chicken Tocino",
            ingredients = "Prepare the Marinade:\n" +
                    "In a bowl, combine the brown sugar, soy sauce, pineapple juice, minced garlic, vinegar (if using), salt, pepper, and annatto powder (if using). Stir until the sugar dissolves completely.\n" +
                    "Add the sliced chicken to the marinade and mix well, making sure all the chicken pieces are coated. Cover the bowl and refrigerate for at least 4 hours, or preferably overnight for a deeper flavor.\n" +
                    " Cook the Chicken Tocino:\n" +
                    "Heat a little cooking oil in a pan over medium heat.\n" +
                    "Once the oil is hot, add the marinated chicken pieces to the pan. Cook the chicken for 4-5 minutes on each side or until the chicken is cooked through and golden brown. Be careful not to burn the sugar as it will caramelize quickly.\n" +
                    "Flip the chicken pieces occasionally to ensure even cooking. You can also cook the chicken in batches if your pan is small to avoid overcrowding.\n" +
                    " Serve:\n" +
                    "Serve the Chicken Tocino hot with steamed rice and a fried egg on the side for a complete \"Tocilog\" meal.\n",
            mealTime = MealTime.LUNCH.label,
            calories = "150 Kcal",
            protein = "15g",
            fats = "  15g",
            carbs = "50g"
        ),
        CHICKENTINOLA(
            mealsId = "MEALSINTERMEDIATE-06",
            imageRes = R.drawable.chickentinola,
            mealsName = "Chicken Tinola",
            ingredients = "Sauté the Aromatics:\n" +
                    "In a large pot, heat the cooking oil over medium heat. Add the smashed garlic, onion, and ginger. Sauté for about 2-3 minutes or until the garlic becomes fragrant and the onions start to soften.\n" +
                    " Brown the Chicken:\n" +
                    "Add the chicken pieces to the pot and cook, turning occasionally, until the chicken is lightly browned on all sides. This step adds flavor to the broth.\n" +
                    " Add Water or Broth:\n" +
                    "Pour in the water (or chicken broth) and bring it to a boil. Skim off any scum or impurities that float to the surface.\n" +
                    "Once the broth is clear, lower the heat and let the chicken simmer for about 30-40 minutes, or until the chicken becomes tender.\n" +
                    " Add the Papaya and Seasonings:\n" +
                    "Add the sliced papaya (or chayote), fish sauce, and green chili peppers (if using). Simmer for another 10-15 minutes, or until the papaya is tender.\n" +
                    "Taste the broth and adjust the seasoning with salt and pepper.\n" +
                    " Add the Greens:\n" +
                    "Add the moringa leaves (or spinach) to the pot, then simmer for another 2-3 minutes, just until the leaves are wilted and tender.\n" +
                    " Serve:\n" +
                    "Once the chicken is fully cooked and the vegetables are tender, remove the pot from the heat.\n" +
                    "Serve the Chicken Tinola hot with a side of steamed rice.",
            mealTime = MealTime.LUNCH.label,
            calories = "188 Kcal",
            protein = "21g",
            fats = "8g",
            carbs = "7g"
        ),
        SINIGANGNAPORK(
            mealsId = "MEALSINTERMEDIATE-07",
            imageRes = R.drawable.sinigangpork,
            mealsName = "Sinigang na pork",
            ingredients = " Boil the Pork:\n" +
                    "In a large pot, add the pork pieces and enough water to cover them. Bring to a boil, then lower the heat to medium and simmer for about 45 minutes to 1 hour or until the pork becomes tender. Skim off any scum that forms on top of the water to keep the broth clear.\n" +
                    " Add the Aromatics:\n" +
                    "Once the pork is tender, add the quartered onion, tomatoes, and green chili peppers. Let it simmer for an additional 10-15 minutes, allowing the flavors to meld.\n" +
                    " Add the Tamarind:\n" +
                    "If you're using fresh tamarind, add the tamarind pods or tamarind paste to the pot and let it simmer for about 10-15 minutes, then mash the tamarind to release its juices and add the tangy flavor to the broth. If you're using a sinigang mix, you can skip this step and add the sinigang mix later according to package instructions.\n" +
                    " Season the Broth:\n" +
                    "Add fish sauce (patis) and bagoong (optional) to taste, adjusting the saltiness of the broth. Simmer for another 5-10 minutes.\n" +
                    " Add the Vegetables:\n" +
                    "Add the sliced radish and eggplant to the pot and cook for about 5 minutes, or until the vegetables are tender but still crisp. If you prefer a thicker broth, you can let it simmer longer.\n" +
                    " Add the Greens:\n" +
                    "Finally, add the kangkong (water spinach) or any leafy greens of your choice. Simmer for 2-3 minutes, just until the greens are wilted and tender.\n" +
                    " Adjust the Seasoning:\n" +
                    "Taste the broth and adjust the seasoning with more fish sauce, salt, or tamarind as needed. The broth should be tangy and savory with a hint of sweetness from the pork.\n" +
                    " Serve:\n" +
                    "Once everything is tender and flavorful, remove the pot from the heat. Serve Sinigang na Pork hot with a side of steamed rice.",
            mealTime = MealTime.LUNCH.label,
            calories = "140 Kcal",
            protein = "30g",
            fats = "25g",
            carbs = "55g"
        ),
        BISTEK(
            mealsId = "MEALSINTERMEDIATE-08",
            imageRes = R.drawable.bistek_tagalog,
            mealsName = "Bistek Tagalog",
            ingredients = " Marinate the Beef:\n" +
                    "In a bowl, combine the soy sauce, calamansi juice (or lemon juice), minced garlic, and a pinch of salt and pepper. Stir well.\n" +
                    "Add the beef slices to the marinade and mix well, making sure the beef is fully coated with the marinade. Let it marinate for at least 30 minutes to 1 hour (or overnight for deeper flavor).\n" +
                    " Sauté the Onions:\n" +
                    "In a large skillet or pan, heat about 1 tablespoon of cooking oil over medium heat.\n" +
                    "Add the sliced onions and cook, stirring occasionally, until they become soft and translucent. Remove them from the pan and set aside.\n" +
                    " Cook the Beef:\n" +
                    "In the same skillet, add the remaining oil and heat it over medium-high heat.\n" +
                    "Add the marinated beef slices (along with a little bit of the marinade for flavor) and cook for 2-3 minutes on each side, or until the beef is lightly browned. You may need to cook the beef in batches to avoid overcrowding the pan.\n" +
                    " Simmer:\n" +
                    "Once all the beef is browned, return all the beef to the pan. Add the water or beef broth to the pan and bring it to a simmer. Let it cook for 10-15 minutes, or until the beef becomes tender and the flavors meld together.\n" +
                    "Taste the broth and adjust the seasoning with salt and pepper, if needed. If the sauce reduces too much, you can add a little more water or broth.\n" +
                    " Add the Onions:\n" +
                    "Once the beef is cooked and tender, add the sautéed onions back to the pan. Stir gently to combine the onions with the beef and simmer for another 2-3 minutes to let the flavors meld.\n" +
                    " Serve:\n" +
                    "Serve the Bistek Tagalog hot with steamed white rice. Garnish with extra onion rings, if desired.\n",
            mealTime = MealTime.LUNCH.label,
            calories = "125 Kcal",
            protein = "30g",
            fats = "25g",
            carbs = "55g"
        ),
        CHICKENCALDS(
            mealsId = "MEALSINTERMEDIATE-09",
            imageRes = R.drawable.chicken_caldereta,
            mealsName = "Chicken Caldereta",
            ingredients =  " Brown the Chicken:\n" +
                    "Heat 1 tablespoon of oil in a large pan or pot over medium-high heat. Add the chicken pieces and cook until lightly browned on all sides. Once browned, remove the chicken from the pan and set aside.\n" +
                    " Sauté Aromatics:\n" +
                    "In the same pan, add another tablespoon of oil. Sauté the chopped onions, garlic, and tomatoes until softened and fragrant, about 3-4 minutes.\n" +
                    " Add the Tomato Sauce:\n" +
                    "Add the tomato sauce and soy sauce to the pan, and stir to combine. Let it simmer for 2-3 minutes, allowing the flavors to develop.\n" +
                    " Return Chicken to the Pot:\n" +
                    "Add the browned chicken back into the pot, along with the bay leaves, pepper, and fish sauce (if using). Stir to coat the chicken with the sauce.\n" +
                    " Add the Vegetables:\n" +
                    "Add the potatoes, carrots, and green peas to the pot. Pour in the water or chicken broth, then stir everything together. Bring the mixture to a boil, then lower the heat and simmer for 25-30 minutes, or until the chicken is cooked through and the vegetables are tender.\n" +
                    " Add Liver Spread:\n" +
                    "Once the chicken and vegetables are tender, add the liver spread (or pureed chicken liver). Stir to combine and let it simmer for another 5-10 minutes, allowing the liver spread to thicken the sauce and enrich the flavor. If the sauce gets too thick, you can add a little more water or chicken broth to reach your desired consistency.\n" +
                    " Season to Taste:\n" +
                    "Taste the sauce and adjust the seasoning with salt, pepper, or sugar as needed. The sugar helps balance out the acidity from the tomato sauce.\n" +
                    " Serve:\n" +
                    "Once everything is tender and the sauce is thickened to your liking, remove the bay leaves and discard them.\n" +
                    "Serve the Chicken Caldereta hot with steamed white rice.\n",
            mealTime = MealTime.LUNCH.label,
            calories = "113 Kcal",
            protein = "30g",
            fats = "25g",
            carbs = "55g"
        ),
        BANGUSBELLY(
            mealsId = "MEALSINTERMEDIATE-10",
            imageRes = R.drawable.bangus_belly,
            mealsName = "Bangus Belly",
            ingredients = " Marinate the Bangus Belly:\n" +
                    "In a bowl, combine the soy sauce, calamansi juice (or lemon juice), minced garlic, black pepper, and fish sauce (optional). Stir well to combine.\n" +
                    "Add the bangus belly pieces to the marinade and toss to coat the fish evenly. Let it marinate for at least 30 minutes to 1 hour in the refrigerator for deeper flavor.\n" +
                    " Prepare for Frying:\n" +
                    "Heat cooking oil in a large frying pan or skillet over medium heat. While waiting for the oil to heat up, remove the bangus belly from the marinade. You can reserve some of the marinade to be used later as a dipping sauce.\n" +
                    " Fry the Bangus Belly:\n" +
                    "Once the oil is hot, carefully place the bangus belly pieces in the pan, skin side down (if there’s skin). Fry for about 4-5 minutes on each side, or until the fish is golden brown and crispy on the outside, and cooked through. Depending on the thickness of the belly slices, you may need to adjust the cooking time.\n" +
                    " Sauté Onions (Optional):\n" +
                    "While the fish is frying, you can sauté the sliced onions in a separate pan with a little oil until they become soft and translucent. This step adds an extra layer of flavor to the dish.\n" +
                    " Serve:\n" +
                    "Once the fish is cooked, remove it from the pan and drain any excess oil on paper towels.\n" +
                    "Transfer the Bangus Belly to a serving plate and garnish with the sautéed onions. Serve with sliced tomatoes and cucumber on the side for a refreshing contrast to the richness of the fish.",
            mealTime = MealTime.LUNCH.label,
            calories = "150 Kcal",
            protein = "23g",
            fats = "0g",
            carbs = "0g"
        ),

        /********************************************************
         *  meals prep for [DINNER]
         ********************************************************
         *  **/
        // for dinner (15)
        dawd(
            mealsId = "1",
            imageRes = R.drawable.tuna_omelette,
            mealsName = "Tuna Omelette",
            ingredients = " Prepare the Ingredients:\n" +
                    "Drain the canned tuna and set it aside.\n" +
                    "Chop the onion, tomato, and bell pepper (if using) into small pieces.\n" +
                    " Beat the Eggs:\n" +
                    "In a bowl, crack the eggs and beat them with a fork or whisk until the yolks and whites are fully combined. Season with a pinch of salt and pepper.\n" +
                    " Sauté the Vegetables:\n" +
                    "Heat the cooking oil or butter in a non-stick skillet over medium heat.\n" +
                    "Add the chopped onions and cook for 1-2 minutes until softened and translucent.\n" +
                    "If you’re using tomato and bell pepper, add them to the skillet and cook for another 2-3 minutes until they soften.\n" +
                    " Add the Tuna:\n" +
                    "Add the drained tuna to the skillet with the vegetables. Use a spatula to break the tuna into smaller pieces, and cook for 1-2 minutes, stirring occasionally. You can add garlic powder or minced garlic here if you like extra flavor.\n" +
                    " Pour in the Eggs:\n" +
                    "Pour the beaten eggs over the tuna and vegetable mixture in the skillet. Let it cook undisturbed for about 2-3 minutes until the edges begin to set.\n" +
                    "Cook the Omelette:\n" +
                    "Once the edges have set, gently lift the sides of the omelette with a spatula, allowing any uncooked egg to flow to the edges.\n" +
                    "When the omelette is mostly set (but slightly runny on top), fold it in half or flip it over for a more even cook. You can cook for another 1-2 minutes until the eggs are fully cooked but still moist inside.\n" +
                    " Serve:\n" +
                    "Once done, transfer the tuna omelette to a plate and garnish with chopped parsley or green onions for a fresh touch.\n" +
                    "Serve with steamed rice, toasted bread, or a side of vegetables.",
            mealTime = MealTime.DINNER.label,
            calories = "350 Kcal",
            protein = "30g",
            carbs = "10g",
            fats = "22g"
        ),
        tawdawwo(
            mealsId = "2",
            imageRes = R.drawable.grilled_bangus_dinner,
            mealsName = "Grilled Bangus",
            ingredients = " Prepare the Marinade:\n" +
                    "In a bowl, combine the soy sauce, calamansi juice (or lemon juice), minced garlic, chopped onions, fish sauce (if using), black pepper, and sugar. Stir well to combine.\n" +
                    " Marinate the Bangus:\n" +
                    "Make small slits on both sides of the bangus to allow the marinade to penetrate the fish.\n" +
                    "Place the bangus in a shallow dish or a resealable plastic bag and pour the marinade over the fish. Make sure the fish is well-coated with the marinade. Let it marinate for at least 30 minutes to 1 hour in the refrigerator. For more flavor, you can marinate it overnight.\n" +
                    " Preheat the Grill:\n" +
                    "Preheat your grill to medium-high heat. If you're using charcoal, let the coals burn until they are covered with white ash. If using a gas grill, set it to medium-high.\n" +
                    " Prepare the Banana Leaves (Optional):\n" +
                    "If using banana leaves, gently heat them over an open flame or in a hot pan to soften them. This helps prevent them from tearing when wrapping the fish. Lay the banana leaves flat on a clean surface.\n" +
                    "Place the marinated bangus in the center of the banana leaves and wrap it up. This will give the fish a nice aroma and protect it from direct flame during grilling.\n" +
                    " Grill the Bangus:\n" +
                    "If you're not using banana leaves, simply brush the grill grates with oil to prevent sticking, then place the marinated bangus directly on the grill.\n" +
                    "Grill the bangus for about 5-7 minutes per side, depending on the size of the fish. You can flip it gently using tongs or a spatula. The fish is done when the flesh is opaque, flaky, and cooked through. Make sure not to overcook the fish to keep it moist.\n" +
                    " Serve:\n" +
                    "Once the bangus is fully cooked, remove it from the grill and let it rest for a few minutes.\n" +
                    "Serve the Grilled Bangus with a side of steamed rice and dipping sauces like soy sauce with calamansi or a vinegar-chili dip.",
            mealTime = MealTime.DINNER.label,
            calories = "340 Kcal",
            protein = "30g",
            carbs = "0g",
            fats = "0g"
        ),
        wda(
            mealsId = "3",
            imageRes = R.drawable.chicken_caldereta_dinner,
            mealsName = "Chicken Caldereta",
            ingredients = ". Marinate the Chicken:\n" +
                    "In a bowl, combine the soy sauce and calamansi juice (or lemon juice). Add the chicken pieces and mix well. Let it marinate for at least 30 minutes to an hour in the refrigerator to enhance the flavor.\n" +
                    " Sauté Aromatics:\n" +
                    "Heat 2 tablespoons of cooking oil in a large pot or deep skillet over medium heat.\n" +
                    "Add the chopped onions and minced garlic. Sauté for 2-3 minutes, until softened and fragrant.\n" +
                    "Add the chopped tomatoes and cook for another 3-4 minutes, until they soften and release their juices.\n" +
                    " Add the Chicken:\n" +
                    "Add the marinated chicken pieces to the pot and cook for 5-7 minutes until the chicken is browned on all sides.\n" +
                    " Add Tomato Sauce and Seasonings:\n" +
                    "Add the tomato sauce, bay leaves, black pepper, and fish sauce (if using) to the pot. Stir to coat the chicken evenly.\n" +
                    "Pour in the water or chicken broth and bring the mixture to a boil. Lower the heat, cover the pot, and let it simmer for about 25-30 minutes, or until the chicken is cooked through and tender.\n" +
                    " Add Vegetables:\n" +
                    "Add the sliced potatoes, carrots, and bell peppers to the pot. Stir everything together and continue to simmer for an additional 10-15 minutes, until the vegetables are tender.\n" +
                    "Add the green peas during the last 5 minutes of cooking.\n" +
                    " Stir in Liver Spread:\n" +
                    "Once the chicken and vegetables are tender, add the liver spread (or blended chicken liver). Stir until the sauce thickens and becomes rich and creamy.\n" +
                    "Taste and adjust the seasoning with salt and sugar (if needed) to balance the acidity from the tomatoes.\n" +
                    " Serve:\n" +
                    "Remove the bay leaves and discard them.\n" +
                    "Serve the Chicken Caldereta hot with steamed rice.",
            mealTime = MealTime.DINNER.label,
            calories = "330 Kcal",
            protein = "28g",
            carbs = "8g",
            fats = "20g"
        ),
        fowdaur(
            mealsId = "4",
            imageRes = R.drawable.pork_nilaga_with_cucumber_dinner,
            mealsName = "Pork nilaga with cucumber",
            ingredients = " Boil the Pork:\n" +
                    "In a large pot, add the pork chunks and pour in the water or pork broth. Bring it to a boil over medium heat.\n" +
                    "Once it starts to boil, lower the heat to a simmer and skim off any scum or impurities that rise to the surface. This will give you a clearer broth.\n" +
                    "Add the onion, garlic, and ginger to the pot. Simmer for about 45 minutes to 1 hour, or until the pork becomes tender. Add more water if needed to keep the pork submerged.\n" +
                    " Add Vegetables:\n" +
                    "Once the pork is tender, add the potatoes (if using), corn (if using), and green beans to the pot. Continue to simmer for another 10-15 minutes until the vegetables are cooked through.\n" +
                    "Add the cabbage and cook for another 5 minutes, or until the cabbage is tender but still slightly crisp.\n" +
                    " Add the Cucumber:\n" +
                    "Add the sliced cucumber to the pot in the last 3-5 minutes of cooking. The cucumber should still be crunchy and refreshing but slightly softened in the soup. Stir gently to combine.\n" +
                    " Season the Soup:\n" +
                    "Season the soup with salt and pepper to taste. You can also add a little fish sauce or soy sauce for a more flavorful broth.\n" +
                    "If you like a bit of spice, you can add the green chilies at this point for a gentle heat.\n" +
                    " Serve:\n" +
                    "Once all the ingredients are tender and the soup is seasoned to your liking, remove the pot from the heat.\n" +
                    "Serve the Pork Nilaga with Cucumber hot, with a side of fish sauce (patis) or soy sauce for dipping.",
            mealTime = MealTime.DINNER.label,
            calories = "340 Kcal",
            protein = "30g",
            carbs = "10g",
            fats = "20g"
        ),
        fivawdwae(
            mealsId = "5",
            imageRes = R.drawable.pork_binagoongan_dinner,
            mealsName = "Pork Binagoongan",
            ingredients = ". Cook the Pork:\n" +
                    "In a large pot or skillet, heat the cooking oil over medium heat. Add the pork cubes and cook until browned and crispy on all sides. This will take about 8-10 minutes. Remove the pork from the pot and set it aside.\n" +
                    " Sauté Aromatics:\n" +
                    "In the same pot, add the chopped onions and minced garlic. Sauté for about 2-3 minutes, until the onions become translucent and the garlic is fragrant.\n" +
                    "Add the chopped tomatoes and cook for another 3-4 minutes, until they soften and release their juices.\n" +
                    " Add the Shrimp Paste:\n" +
                    "Stir in the shrimp paste (bagoong) and cook it for about 2-3 minutes, allowing it to release its flavors. If you prefer a milder flavor, you can rinse the shrimp paste before adding it to the pot.\n" +
                    " Add Vinegar and Simmer:\n" +
                    "Pour in the vinegar and let it simmer for about 2-3 minutes to cook off the strong vinegar flavor. Do not stir immediately, as this allows the vinegar to cook properly.\n" +
                    " Add the Coconut Milk (Optional):\n" +
                    "If you’re using coconut milk, add it to the pot now along with the water or pork broth. Stir to combine and bring the mixture to a simmer. Let it cook for about 5 minutes.\n" +
                    " Combine the Pork:\n" +
                    "Return the cooked pork cubes to the pot and stir to coat them with the sauce. Let it simmer for about 10-15 minutes, or until the pork is tender and the sauce has thickened. You can add more water or broth if the sauce becomes too thick.\n" +
                    " Add Vegetables and Season:\n" +
                    "Add the sliced green chilies and bell peppers (if using), and continue to simmer for an additional 5 minutes until the peppers soften.\n" +
                    "Season with salt, pepper, and sugar to taste. Adjust the seasoning according to your preference. If you like it tangier, a squeeze of calamansi or lemon juice can add a nice touch.\n" +
                    "Serve:\n" +
                    "Once the pork is tender and the sauce is flavorful, remove from heat.\n" +
                    "Serve the Pork Binagoongan with steamed white rice. Enjoy the savory, umami-packed dish!\n",
            mealTime = MealTime.DINNER.label,
            calories = "320 Kcal",
            protein = "30g",
            carbs = "7g",
            fats = "18g"
        ),
        siawdx(
            mealsId = "6",
            imageRes = R.drawable.pinakbet_dinner,
            mealsName = "Pinakbet",
            ingredients = " Cook the Pork:\n" +
                    "In a large pot or skillet, heat the cooking oil over medium heat. Add the pork cubes and cook until browned and crispy on all sides. This will take about 8-10 minutes. Remove the pork from the pot and set it aside.\n" +
                    " Sauté Aromatics:\n" +
                    "In the same pot, add the chopped onions and minced garlic. Sauté for about 2-3 minutes, until the onions become translucent and the garlic is fragrant.\n" +
                    "Add the chopped tomatoes and cook for another 3-4 minutes, until they soften and release their juices.\n" +
                    " Add the Shrimp Paste:\n" +
                    "Stir in the shrimp paste (bagoong) and cook it for about 2-3 minutes, allowing it to release its flavors. If you prefer a milder flavor, you can rinse the shrimp paste before adding it to the pot.\n" +
                    " Add Vinegar and Simmer:\n" +
                    "Pour in the vinegar and let it simmer for about 2-3 minutes to cook off the strong vinegar flavor. Do not stir immediately, as this allows the vinegar to cook properly.\n" +
                    " Add the Coconut Milk (Optional):\n" +
                    "If you’re using coconut milk, add it to the pot now along with the water or pork broth. Stir to combine and bring the mixture to a simmer. Let it cook for about 5 minutes.\n" +
                    " Combine the Pork:\n" +
                    "Return the cooked pork cubes to the pot and stir to coat them with the sauce. Let it simmer for about 10-15 minutes, or until the pork is tender and the sauce has thickened. You can add more water or broth if the sauce becomes too thick.\n" +
                    " Add Vegetables and Season:\n" +
                    "Add the sliced green chilies and bell peppers (if using), and continue to simmer for an additional 5 minutes until the peppers soften.\n" +
                    "Season with salt, pepper, and sugar to taste. Adjust the seasoning according to your preference. If you like it tangier, a squeeze of calamansi or lemon juice can add a nice touch.\n" +
                    " Serve:\n" +
                    "Once the pork is tender and the sauce is flavorful, remove from heat.\n" +
                    "Serve the Pork Binagoongan with steamed white rice. Enjoy the savory, umami-packed dish!\n",
            mealTime = MealTime.DINNER.label,
            calories = "310 Kcal",
            protein = "48g",
            carbs = "9g",
            fats = "17g"
        ),
        sewadven(
            mealsId = "7",
            imageRes = R.drawable.tuna_omellete_with_mango_dinner,
            mealsName = "Tuna Omelette with mango",
            ingredients = " Prepare the Mango:\n" +
                    "Peel the mango and slice it into thin strips or small cubes. Set aside.\n" +
                    " Prepare the Tuna Mixture:\n" +
                    "In a bowl, combine the drained and flaked tuna with the mayonnaise (optional). Mix well. You can also add a pinch of salt and pepper or a dash of lemon or calamansi juice for extra flavor. If you're using onion and tomato, add them to the tuna mixture and mix.\n" +
                    "Make the Omelette:\n" +
                    "In a separate bowl, crack the eggs and beat them well with a pinch of salt and pepper.\n" +
                    "Heat a non-stick frying pan over medium heat and add a tablespoon of oil or butter.\n" +
                    "Pour the beaten eggs into the pan and let them cook for 1-2 minutes, gently swirling the pan to make sure the eggs are evenly distributed.\n" +
                    " Add the Tuna Mixture:\n" +
                    "Once the eggs start to set but are still slightly runny on top, spoon the tuna mixture onto one half of the omelette. Let it cook for another 1-2 minutes until the eggs are fully set and the tuna is heated through.\n" +
                    " Add Mango:\n" +
                    "Once the omelette is cooked, gently fold it in half to enclose the tuna mixture.\n" +
                    "Top the omelette with the fresh mango slices or cubes for a sweet contrast to the savory tuna.\n" +
                    " Serve:\n" +
                    "Carefully slide the omelette onto a plate. Garnish with fresh cilantro or parsley for a fresh, vibrant touch.\n" +
                    "Serve immediately with a side of rice or as a light meal on its own.",
            mealTime = MealTime.DINNER.label,
            calories = "310 Kcal",
            protein = "29g",
            carbs = "8g",
            fats = "19g"
        ),
        eiwdght(
            mealsId = "8",
            imageRes = R.drawable.grilled_tilapia_dinner,
            mealsName = "Grilled Tilapia",
            ingredients = " Prepare the Marinade:\n" +
                    "In a small bowl, combine the olive oil, minced garlic, lemon or calamansi juice, salt, pepper, soy sauce, and fish sauce (if using). If you like a bit of heat, you can add paprika or chili powder to the mix.\n" +
                    " Marinate the Tilapia:\n" +
                    "Rub the marinade all over the whole tilapia (inside and out) or the fillets. Make sure the fish is evenly coated with the marinade.\n" +
                    "Allow the fish to marinate for at least 15-30 minutes. If you have more time, you can let it marinate for up to 1 hour in the fridge for a deeper flavor.\n" +
                    "Preheat the Grill:\n" +
                    "Preheat your grill to medium-high heat. If you're using a charcoal grill, make sure the coals are evenly distributed. For gas grills, set the temperature to about 375-400°F (190-200°C).\n" +
                    " Grill the Tilapia:\n" +
                    "If you're grilling whole tilapia, place the fish on the grill. You can also use a grill basket to keep the fish from falling apart or sticking to the grill. Grill the tilapia for about 4-6 minutes on each side, depending on the size of the fish. The fish should be golden brown and have grill marks.\n" +
                    "For tilapia fillets, grill them for about 3-4 minutes on each side, or until the fish easily flakes with a fork.\n" +
                    " Check for Doneness:\n" +
                    "The tilapia is done when it flakes easily with a fork and reaches an internal temperature of about 145°F (63°C). Be careful not to overcook it, as tilapia is a delicate fish.\n" +
                    " Serve:\n" +
                    "Remove the grilled tilapia from the grill and transfer it to a serving plate. Garnish with fresh herbs like parsley or cilantro, and serve with lemon slices on the side for squeezing.\n" +
                    "You can pair the grilled tilapia with steamed rice, a side of vegetables, or a fresh salad.",
            mealTime = MealTime.DINNER.label,
            calories = "340 Kcal",
            protein = "38g",
            carbs = "10g",
            fats = "20g"
        ),
        niawdne(
            mealsId = "9",
            imageRes = R.drawable.chicken_tocino_dinner,
            mealsName = "Chicken Tocino",
            ingredients = " Prepare the Marinade:\n" +
                    "In a bowl, combine the brown sugar, soy sauce, pineapple juice (or calamansi juice), minced garlic, salt, black pepper, and annatto powder (if using). If you want a slight tanginess, add the vinegar to the mix.\n" +
                    "Stir everything together until the sugar dissolves and the marinade is well-combined.\n" +
                    " Marinate the Chicken:\n" +
                    "Add the sliced chicken to the marinade and make sure each piece is well-coated.\n" +
                    "Cover the bowl and refrigerate the chicken for at least 4 hours, preferably overnight, for the best flavor.\n" +
                    " Cook the Chicken Tocino:\n" +
                    "Heat the oil in a large pan or skillet over medium heat.\n" +
                    "Once the oil is hot, add the marinated chicken slices, spreading them out in a single layer. Avoid overcrowding the pan; you may need to cook the chicken in batches.\n" +
                    "Cook the chicken for about 3-4 minutes on each side, until it’s browned and cooked through. The sugar in the marinade will caramelize, giving the chicken a slightly crispy, sweet exterior.\n" +
                    "Keep an eye on the heat to avoid burning the chicken; you want it to cook evenly and get that perfect balance of sweetness and savory flavors.\n" +
                    " Serve:\n" +
                    "Once cooked, transfer the chicken tocino to a plate lined with paper towels to drain any excess oil.\n" +
                    "Serve with garlic rice (sinangag) and a fried egg for the classic Filipino breakfast combo.",
            mealTime = MealTime.DINNER.label,
            calories = "325 Kcal" ,
            protein = "28g",
            carbs = "8g",
            fats = "19g"
        ),
        teawdn(
            mealsId = "10",
            imageRes = R.drawable.chicken_adobo_dinner,
            mealsName = "Chicken Adobo",
            ingredients = " Prepare the Marinade:\n" +
                    "In a bowl, combine the brown sugar, soy sauce, pineapple juice (or calamansi juice), minced garlic, salt, black pepper, and annatto powder (if using). If you want a slight tanginess, add the vinegar to the mix.\n" +
                    "Stir everything together until the sugar dissolves and the marinade is well-combined.\n" +
                    " Marinate the Chicken:\n" +
                    "Add the sliced chicken to the marinade and make sure each piece is well-coated.\n" +
                    "Cover the bowl and refrigerate the chicken for at least 4 hours, preferably overnight, for the best flavor.\n" +
                    " Cook the Chicken Tocino:\n" +
                    "Heat the oil in a large pan or skillet over medium heat.\n" +
                    "Once the oil is hot, add the marinated chicken slices, spreading them out in a single layer. Avoid overcrowding the pan; you may need to cook the chicken in batches.\n" +
                    "Cook the chicken for about 3-4 minutes on each side, until it’s browned and cooked through. The sugar in the marinade will caramelize, giving the chicken a slightly crispy, sweet exterior.\n" +
                    "Keep an eye on the heat to avoid burning the chicken; you want it to cook evenly and get that perfect balance of sweetness and savory flavors.\n" +
                    " Serve:\n" +
                    "Once cooked, transfer the chicken tocino to a plate lined with paper towels to drain any excess oil.\n" +
                    "Serve with garlic rice (sinangag) and a fried egg for the classic Filipino breakfast combo.",
            mealTime = MealTime.DINNER.label,
            calories = "330 Kcal",
            protein = "34g",
            carbs = "9g",
            fats = "18g"
        ),
        elawdeven(
            mealsId = "11",
            imageRes = R.drawable.arrozcaldo,
            mealsName = "Arrozcaldo",
            ingredients = "I Sauté the Aromatics:\n" +
                    "Heat the oil in a large pot over medium heat. Add the chopped onion, garlic, and ginger, sautéing until they become fragrant and the onions soften, about 2-3 minutes.\n" +
                    " Cook the Chicken:\n" +
                    "Add the chicken pieces to the pot, and cook for 5-7 minutes, stirring occasionally, until the chicken is lightly browned on all sides.\n" +
                    " Add the Rice and Broth:\n" +
                    "Add the rice to the pot and stir to coat the rice with the chicken and aromatics.\n" +
                    "Pour in the chicken broth (or water if you don’t have broth), and bring it to a boil.\n" +
                    "Once boiling, lower the heat and let the rice simmer, uncovered, for about 25-30 minutes or until the rice is cooked and the mixture has thickened to a porridge-like consistency. Stir occasionally to prevent the rice from sticking to the bottom of the pot.\n" +
                    " Season:\n" +
                    "Add the fish sauce (or soy sauce), salt, and pepper to taste. Adjust the seasoning based on your preference.\n" +
                    "5. Serve:\n" +
                    "Ladle the arroz caldo into bowls and top each serving with a hard-boiled egg (if desired), fried garlic, and chopped green onions.\n" +
                    "Serve with calamansi (or lemon) on the side for a bit of tang.\n",
            mealTime = MealTime.DINNER.label,
            calories = "340 Kcal",
            protein = "31g",
            carbs = "10g",
            fats = "19g"
        ),
        twawdelve(
            mealsId = "12",
            imageRes = R.drawable.bistek_tagalog,
            mealsName = "Bistek Tagalog",
            ingredients = " Marinate the Beef:\n" +
                    "In a bowl, combine the soy sauce, calamansi juice, minced garlic, ground black pepper, and a pinch of salt.\n" +
                    "Add the sliced beef into the marinade and mix well to ensure the beef is evenly coated.\n" +
                    "Cover and refrigerate the beef for at least 30 minutes to an hour. For best results, marinate for a few hours or overnight.\n" +
                    " Sauté the Onions:\n" +
                    "Heat 2 tablespoons of oil in a large skillet or wok over medium heat.\n" +
                    "Add the sliced onions and sauté them until they become soft and translucent. Once cooked, set the onions aside for garnish.\n" +
                    " Cook the Beef:\n" +
                    "In the same skillet, add the remaining oil and heat over medium-high heat.\n" +
                    "Add the marinated beef, including the garlic and marinade. Sauté for about 5-7 minutes, allowing the beef to cook and absorb the flavors. If the sauce gets too thick, add a little bit of water or beef broth to loosen it up.\n" +
                    "Taste and adjust the seasoning by adding more soy sauce or salt if necessary. If you prefer a slightly sweeter flavor, you can stir in a bit of sugar.\n" +
                    " Final Touches:\n" +
                    "Once the beef is tender and the sauce has reduced slightly, add the sautéed onions back into the pan, mixing them with the beef for a minute or two.\n" +
                    " Serve:\n" +
                    "Transfer the Bistek Tagalog to a serving dish and garnish with the sautéed onions on top.\n" +
                    "Serve hot with steamed rice.",
            mealTime = MealTime.DINNER.label,
            calories = "335 Kcal",
            protein = "30g",
            carbs = "9g",
            fats = "18g"
        ),
        thiawdrteen(
            mealsId = "13",
            imageRes = R.drawable.egg_with_rice,
            mealsName = "Egg with rice",
            ingredients = " Prepare the Rice:\n" +
                    "If you don’t have leftover rice, cook the rice first and set it aside. The rice should be warm when you prepare the eggs to ensure the dish is hot when served.\n" +
                    " Cook the Eggs:\n" +
                    "Heat the oil or butter in a pan over medium heat.\n" +
                    "Crack the eggs into the pan. You can scramble the eggs or cook them sunny-side up, depending on your preference.\n" +
                    "For scrambled eggs: Beat the eggs in a bowl before adding them to the pan. Stir constantly until fully cooked.\n" +
                    "For sunny-side-up eggs: Let the eggs cook on low heat until the whites are set but the yolks remain runny. Optionally, cover the pan to cook the eggs more evenly.\n" +
                    "Season with a pinch of salt and pepper to taste.\n" +
                    " Combine with Rice:\n" +
                    "Add the cooked rice to the pan (if you want to mix it all together) or serve the eggs on top of the rice in a bowl.\n" +
                    "Stir the rice and eggs together in the pan, breaking up the eggs and combining them with the rice, or simply serve the fried eggs over a bed of rice for a more simple presentation.\n" +
                    " Optional Toppings and Seasoning:\n" +
                    "You can drizzle a little soy sauce over the egg and rice, or add a dollop of ketchup if you like.\n" +
                    "Garnish with green onions, fried garlic, or chili flakes for extra flavor.",
            mealTime = MealTime.DINNER.label,
            calories = "320 Kcal",
            protein = "28g",
            carbs = "8g",
            fats = "18g"
        ),
        fouadwadrteen(
            mealsId = "14",
            imageRes = R.drawable.grilled_tilapia_w_spinach_dinner,
            mealsName = "Grilled tilapia with spinach",
            ingredients = " Prepare the Grilled Tilapia:\n" +
                    "Preheat your grill or grill pan over medium-high heat.\n" +
                    "If using whole tilapia, make sure it’s cleaned and patted dry with a paper towel.\n" +
                    "In a small bowl, combine the olive oil, minced garlic, lemon juice, lemon zest, paprika (if using), salt, and pepper. Rub this mixture all over the tilapia, ensuring the fish is well-coated. Let it marinate for about 10-15 minutes.\n" +
                    "If you’re using tilapia fillets, simply coat them with the marinade and let them sit for a few minutes.\n" +
                    "Place the fish on the grill or in a preheated grill pan. Grill the whole fish for 5-7 minutes per side or until the flesh is opaque and flakes easily with a fork. If using fillets, cook for 3-4 minutes per side.\n" +
                    "Once done, remove the fish from the grill and set it aside, garnishing with fresh herbs if desired.\n" +
                    " Prepare the Sautéed Spinach:\n" +
                    "While the fish is grilling, heat olive oil (or butter) in a large skillet over medium heat.\n" +
                    "Add the minced garlic and chopped onion (if using), and sauté for 1-2 minutes until fragrant.\n" +
                    "Add the spinach to the skillet, tossing it gently to coat with the garlic and oil. Cook for 2-3 minutes, stirring occasionally, until the spinach is wilted and tender.\n" +
                    "Season with salt and pepper to taste. You can also add a squeeze of lemon juice for a touch of freshness.\n" +
                    "Remove from heat once the spinach is cooked to your liking.\n" +
                    " Serve:\n" +
                    "Plate the grilled tilapia and serve it alongside the sautéed spinach.\n" +
                    "For an added touch, you can serve with a side of roasted potatoes, rice, or a simple salad.",
            mealTime = MealTime.DINNER.label,
            calories = "330 Kcal",
            protein = "32g",
            carbs = "10g",
            fats = "19g"
        ),
        fivwdeteen(
            mealsId = "15",
            imageRes = R.drawable.kare_kare,
            mealsName = "Kare-kare",
            ingredients = " Cook the Oxtail:\n" +
                    "In a large pot, add the oxtail (or beef shank and tripes) and cover with water. Bring to a boil, then lower the heat and simmer for about 1.5 to 2 hours, or until the meat is tender. Skim off any scum that rises to the top.\n" +
                    "Alternatively, you can pressure cook the oxtail for faster cooking. After it’s tender, remove the oxtail from the pot and set aside. Keep the broth as you will use it for the sauce.\n" +
                    " Prepare the Peanut Sauce:\n" +
                    "In a separate pan, heat a little oil and sauté the chopped onion and garlic until softened and fragrant.\n" +
                    "Add the annatto powder (or annatto seeds) to the pan and cook for about 1-2 minutes to infuse the oil with color.\n" +
                    "Add the cooked oxtail broth (about 4-5 cups), peanut butter (or ground peanuts), and fish sauce. Stir to combine, ensuring the peanut butter is fully incorporated. Let the mixture simmer for 10-15 minutes to thicken slightly and to allow the flavors to meld. If you want a thicker consistency, you can add more peanut butter or a little cornstarch mixed with water.\n" +
                    " Add Vegetables:\n" +
                    "Add the eggplant, string beans, and banana heart (if using) to the pot, and let them cook for about 5-7 minutes, or until tender.\n" +
                    "Add the bok choy or pechay and cook for another 2-3 minutes until the greens are wilted.\n" +
                    "4. Final Seasoning:\n" +
                    "Taste the sauce and adjust the seasoning with salt or fish sauce, and a bit of sugar if needed to balance the flavors.\n" +
                    "Make the Bagoong (Optional):\n" +
                    "In a separate pan, heat oil and sauté the onion and tomato until softened.\n" +
                    "Add the shrimp paste (bagoong alamang) and cook for about 5-7 minutes, stirring occasionally.\n" +
                    "Add sugar if you prefer a sweeter taste to balance the salty bagoong.\n" +
                    " Serve:\n" +
                    "Transfer the Kare-Kare to a serving dish and serve hot with steamed rice.\n" +
                    "Place the shrimp paste (bagoong) on the side, allowing guests to mix it with their Kare-Kare to taste.",
            mealTime = MealTime.DINNER.label,
            calories = "325 Kcal",
            protein = "29g",
            carbs = "8g",
            fats = "19g"
        )
}


/********************************************************
 *  meals prep for [BodyFatLevel.NATURAL]
 ********************************************************
 *  **/
enum class MealsCategoriesForNatural(val mealsId: String,
                                     @DrawableRes val imageRes: Int,
                                     val mealsName: String,
                                     val ingredients: String,
                                     val mealTime: String,
                                     val fats: String,
                                     val protein: String,
                                     val carbs: String,
                                     val calories:  String){


    /********************************************************
     *  meals prep for [BREAKFAST]
     ********************************************************
     *  **/
    Tuna(
        mealsId = "TUNA-01",
        imageRes = R.drawable.chicken_tocino_breakfast,
        mealsName = "Chicken Tocino",
        ingredients = "A sweet and savory Filipino dish made with marinated chicken, garlic, and sugar, typically served with rice.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "350",
        protein = "30g",
        carbs = "40g",
        fats = "15g"
    ),
    two(
        mealsId = "TUNA-02",
        imageRes = R.drawable.chickentinola_breakfast,
        mealsName = "Chicken Tinola",
        ingredients = "A Filipino chicken soup made with ginger, green papaya, and chili leaves for a fresh and savory flavor.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "400",
        protein = "35g",
        carbs = "45g",
        fats = "20g"
    ),
    three(
        mealsId = "TUNA-03",
        imageRes = R.drawable.inihawnababoybreakfast,
        mealsName = "Inihaw na Baboy",
        ingredients = "Grilled pork marinated in a blend of soy sauce, garlic, and vinegar, served with rice.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "500",
        protein = "40g",
        carbs = "55g",
        fats = "25g"
    ),
    four(
        mealsId = "TUNA-04",
        imageRes = R.drawable.chicken_tocino_with_brown_rice_breakfast,
        mealsName = "Chicken Tocino with Brown Rice",
        ingredients = "Marinated chicken cooked with garlic and sugar, paired with healthy brown rice.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "480",
        protein = "35g",
        carbs = "60g",
        fats = "18g"
    ),
    five(
        mealsId = "TUNA-05",
        imageRes = R.drawable.fish_escabeche_breakfast,
        mealsName = "Fish Escabeche",
        ingredients = "Fried fish served with a sweet and sour vegetable sauce.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "450",
        protein = "35g",
        carbs = "55g",
        fats = "20g"
    ),
    six(
        mealsId = "TUNA-06",
        imageRes = R.drawable.grilled_chicken_inasal__breakfast,
        mealsName = "Grilled Chicken Inasal",
        ingredients = "Grilled chicken marinated in vinegar, lemongrass, and spices, perfect for breakfast.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "370",
        protein = "40g",
        carbs = "50g",
        fats = "15g"
    ),
    seven(
        mealsId = "TUNA-07",
        imageRes = R.drawable.pandesal_spread_with_creamy_peanut_butter_breakfast,
        mealsName = "Pandesal with Creamy Peanut Butter",
        ingredients = "A soft pandesal bread spread with creamy peanut butter, a perfect snack or breakfast.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "300",
        protein = "10g",
        carbs = "45g",
        fats = "12g"
    ),
    eight(
        mealsId = "TUNA-08",
        imageRes = R.drawable.paksiw_na_pata_breakfast,
        mealsName = "Paksiw na Pata",
        ingredients = "Pork hock cooked in vinegar, soy sauce, and spices for a tangy and savory breakfast dish.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "550",
        protein = "35g",
        carbs = "50g",
        fats = "30g"
    ),
    nine(
        mealsId = "TUNA-09",
        imageRes = R.drawable.oatmeal_with_almond_milk__topped_with_bananas_and_chia_seeds_boiled_egg_breakfast,
        mealsName = "Oatmeal with Almond Milk, Bananas, and Chia Seeds",
        ingredients = "A healthy breakfast with oatmeal topped with bananas and chia seeds, served with a boiled egg.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "350",
        protein = "15g",
        carbs = "50g",
        fats = "12g"
    ),
    ten(
        mealsId = "TUNA-10",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "Tuna Omelette",
        ingredients = "A protein-packed omelette made with tuna, eggs, and vegetables.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "400",
        protein = "30g",
        carbs = "20g",
        fats = "25g"
    ),
    eleven(
        mealsId = "TUNA-11",
        imageRes = R.drawable.scrambled_eggs_made_with_3_eggs_breakfast,
        mealsName = "Scrambled Eggs (3 Eggs)",
        ingredients = "Fluffy scrambled eggs made with three eggs for a protein-rich breakfast.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "330",
        protein = "24g",
        carbs = "5g",
        fats = "24g"
    ),
    twelve(
        mealsId = "TUNA-12",
        imageRes = R.drawable.tinolang_manok__chicken_stew__breakfast,
        mealsName = "Tinolang Manok",
        ingredients = "A light and flavorful chicken stew with ginger, papaya, and chili leaves.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "380",
        protein = "32g",
        carbs = "30g",
        fats = "15g"
    ),
    thirteen(
        mealsId = "TUNA-13",
        imageRes = R.drawable.sinigang_na_hipon_breakfast,
        mealsName = "Sinigang na Hipon",
        ingredients = "A sour shrimp soup with tamarind and vegetables.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "300",
        protein = "28g",
        carbs = "40g",
        fats = "10g"
    ),
    fourteen(
        mealsId = "TUNA-14",
        imageRes = R.drawable.tinola_with_malunggay__chicken_tinola__breakfast,
        mealsName = "Chicken Tinola with Malunggay",
        ingredients = "Chicken tinola soup with moringa leaves for added nutrition.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "350",
        protein = "30g",
        carbs = "35g",
        fats = "12g"
    ),
    fiveteen(
        mealsId = "TUNA-15",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "Tuna Omelette",
        ingredients = "A delicious tuna omelette filled with fresh vegetables and eggs.",
        mealTime = MealTime.BREAKFAST.label,
        calories = "400",
        protein = "35g",
        carbs = "20g",
        fats = "25g"
    )
,
    /********************************************************
     *  meals prep for [LUNCH]
     ********************************************************
     *  **/
    TUNAOMELET(
        mealsId = "MEALSADVANCE-01",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "Tuna Omelet",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "150",
        protein = "15",
        fats = "10",
        carbs = "40"
    ),
    SINIGANG(
        mealsId = "MEALSADVANCE-02",
        imageRes = R.drawable.sinigang,
        mealsName = "Sinigang na Beef",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "168",
        protein = "30",
        fats = "25",
        carbs = "55"
    ),
    KAREKARE(
        mealsId = "MEALSADVANCE-04",
        imageRes = R.drawable.kare_kare,
        mealsName = "Kare-Kare",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "183",
        protein = "35",
        fats = "15",
        carbs = "50"
    ),
    CHICKENTOCINO(
        mealsId = "MEALSADVANCE-05",
        imageRes = R.drawable.chikentocino,
        mealsName = "Chicken Tocino",
        ingredients = ".",
        mealTime = MealTime.LUNCH.label,
        calories = "145",
        protein = "15",
        fats = "15",
        carbs = "50"
    ),
    PORKMINUDO(
        mealsId = "MEALSADVANCE-06",
        imageRes = R.drawable.pork_menudo,
        mealsName = "Pork Menudo",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "132",
        protein = "21",
        fats = "8",
        carbs = "7"
    ),
    SINIGANGNAPORK(
        mealsId = "MEALSADVANCE-07",
        imageRes = R.drawable.sinigangpork,
        mealsName = "Sinigang na Pork",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "150",
        protein = "30",
        fats = "25",
        carbs = "55"
    ),
    BISTEK(
        mealsId = "MEALSADVANCE-08",
        imageRes = R.drawable.bistek_tagalog,
        mealsName = "Bistek Tagalog",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "150",
        protein = "30",
        fats = "25",
        carbs = "55"
    ),
    LONGSILOG(
        mealsId = "MEALSADVANCE-09",
        imageRes = R.drawable.longsilog,
        mealsName = "Longganisa Itlog",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "145",
        protein = "30",
        fats = "25",
        carbs = "55"
    ),
    SCRAMBLEEGGS(
        mealsId = "MEALSADVANCE-10",
        imageRes = R.drawable.scrambleeggs,
        mealsName = "Scramble Eggs",
        ingredients = "",
        mealTime = MealTime.LUNCH.label,
        calories = "120",
        protein = "30",
        fats = "25",
        carbs = "55"
    ),
    AFAE(
        mealsId = "",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "",
        ingredients = "",
        mealTime = "",
        calories = "",
        protein = "",
        carbs = "",
        fats = ""
    ),
    SEFGEF(
        mealsId = "",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "",
        ingredients = "",
        mealTime = "",
        calories = "",
        protein = "",
        carbs = "",
        fats = ""
    ),
    FAWFAFRF(
        mealsId = "",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "",
        ingredients = "",
        mealTime = "",
        calories = "",
        protein = "",
        carbs = "",
        fats = ""
    ),
    FAWOHOAWF(
        mealsId = "",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "",
        ingredients = "",
        mealTime = "",
        calories = "",
        protein = "",
        carbs = "",
        fats = ""
    ),
    FIVWDEAFAFATEEN(
        mealsId = "",
        imageRes = R.drawable.tuna_omelette,
        mealsName = "",
        ingredients = "",
        mealTime = "",
        calories = "",
        protein = "",
        carbs = "",
        fats = ""
    )
,
    /********************************************************
     *  meals prep for [DINNER]
     ********************************************************
     *  **/
    // for dinner (15)
    dawd(
        mealsId = "1",
        imageRes = R.drawable.beef_caldereta_dinner,
        mealsName = "Beef Caldereta",
        ingredients = "A hearty Filipino beef stew cooked with tomato sauce, potatoes, and vegetables for a rich and flavorful dish.",
        mealTime = MealTime.DINNER.label,
        calories = "350",
        protein = "35g",
        carbs = "59g",
        fats = "77g"
    ),
    tawdawwo(
        mealsId = "2",
        imageRes = R.drawable.chicken_adobo_dinner,
        mealsName = "Chicken Adobo",
        ingredients = "A classic Filipino dish made with chicken, soy sauce, vinegar, garlic, and bay leaves, creating a savory and tangy flavor.",
        mealTime = MealTime.DINNER.label,
        calories = "380",
        protein = "54g",
        carbs = "54g",
        fats = "54g"
    ),
    wda(
        mealsId = "3",
        imageRes = R.drawable.chicken_caldereta_dinner,
        mealsName = "Chicken Caldereta",
        ingredients = "A rich and savory chicken stew made with tomato sauce, potatoes, and vegetables, offering a deliciously tender texture.",
        mealTime = MealTime.DINNER.label,
        calories = "460",
        protein = "6g",
        carbs = "4g",
        fats = "5g"
    ),
    fowdaur(
        mealsId = "4",
        imageRes = R.drawable.pinakbet_dinner,
        mealsName = "Pinakbet",
        ingredients = "A traditional Filipino vegetable dish made with a variety of vegetables like bitter melon, eggplant, and okra, cooked with shrimp paste.",
        mealTime = MealTime.DINNER.label,
        calories = "245",
        protein = "54g",
        carbs = "5g",
        fats = "56g"
    ),
    fivawdwae(
        mealsId = "5",
        imageRes = R.drawable.chicken_caldereta_dinner,
        mealsName = "Chicken Caldereta",
        ingredients = "A savory Filipino stew made with tender chicken, tomato sauce, potatoes, and a variety of vegetables.",
        mealTime = MealTime.DINNER.label,
        calories = "400",
        protein = "55g",
        carbs = "5g",
        fats = "65g"
    ),
    siawdx(
        mealsId = "6",
        imageRes = R.drawable.bangus_belly_sinigang_dinner,
        mealsName = "Bangus Belly Sinigang",
        ingredients = "A tangy and savory Filipino soup made with bangus (milkfish) belly, tamarind, and assorted vegetables for a refreshing taste.",
        mealTime = MealTime.DINNER.label,
        calories = "250",
        protein = "54g",
        carbs = "45g",
        fats = "45g"
    ),
    sewadven(
        mealsId = "7",
        imageRes = R.drawable.grilled_bangus_dinner,
        mealsName = "Grilled Bangus",
        ingredients = "Grilled milkfish marinated with spices and served with a side of fresh vegetables or rice for a tasty and healthy meal.",
        mealTime = MealTime.DINNER.label,
        calories = "320",
        protein = "56g",
        carbs = "65g",
        fats = "45g"
    ),
    eiwdght(
        mealsId = "8",
        imageRes = R.drawable.grilled_tilapia_w_spinach_dinner,
        mealsName = "Grilled Tilapia with Spinach",
        ingredients = "A healthy meal consisting of grilled tilapia paired with spinach, offering a rich source of protein and nutrients.",
        mealTime = MealTime.DINNER.label,
        calories = "330",
        protein = "65g",
        carbs = "56g",
        fats = "15g"
    ),
    niawdne(
        mealsId = "9",
        imageRes = R.drawable.pork_binagoongan_dinner,
        mealsName = "Pork Binagoongan",
        ingredients = "Pork cooked with shrimp paste, tomatoes, and eggplant, creating a savory and umami-rich Filipino dish.",
        mealTime = MealTime.DINNER.label,
        calories = "370",
        protein = "34g",
        carbs = "34g",
        fats = "34g"
    ),
    teawdn(
        mealsId = "10",
        imageRes = R.drawable.chicken_tocino_dinner,
        mealsName = "Chicken Tocino",
        ingredients = "A sweet and savory Filipino dish made with marinated chicken, garlic, and sugar, typically served with rice.",
        mealTime = MealTime.DINNER.label,
        calories = "340",
        protein = "34g",
        carbs = "34g",
        fats = "34g"
    ),
    elawdeven(
        mealsId = "11",
        imageRes = R.drawable.tuna_omellete_with_mango_dinner,
        mealsName = "Tuna Omelette",
        ingredients = "A protein-packed omelette with tuna, eggs, and fresh mango for a light and flavorful dinner.",
        mealTime = MealTime.DINNER.label,
        calories = "330",
        protein = "34g",
        carbs = "34g",
        fats = "34g"
    ),
    twawdelve(
        mealsId = "12",
        imageRes = R.drawable.pandesal_with_peanut_and_papaya_dinner,
        mealsName = "Bread with Peanut Butter",
        ingredients = "Soft pandesal bread filled with creamy peanut butter and served with fresh papaya slices for a simple yet satisfying meal.",
        mealTime = MealTime.DINNER.label,
        calories = "350",
        protein = "15g",
        carbs = "45g",
        fats = "20g"
    ),
    thiawdrteen(
        mealsId = "13",
        imageRes = R.drawable.tuna_pandesal_dinner,
        mealsName = "Tuna Pandesal",
        ingredients = "A Filipino sandwich made with pandesal rolls filled with tuna salad, offering a tasty and convenient meal.",
        mealTime = MealTime.DINNER.label,
        calories = "400",
        protein = "23g",
        carbs = "45g",
        fats = "20g"
    ),
    fouadwadrteen(
        mealsId = "14",
        imageRes = R.drawable.pork_nilaga_with_cucumber_dinner,
        mealsName = "Pork Nilaga with Cucumber",
        ingredients = "A simple and comforting Filipino soup made with boiled pork and served with fresh cucumber on the side.",
        mealTime = MealTime.DINNER.label,
        calories = "320",
        protein = "34g",
        carbs = "52g",
        fats = "23g"
    ),
    fivwdeteen(
        mealsId = "15",
        imageRes = R.drawable.tuna__dinner,
        mealsName = "Tuna with Rice",
        ingredients = "A quick and nutritious meal of tuna served with steamed rice, providing a good balance of protein and carbs.",
        mealTime = MealTime.DINNER.label,
        calories = "350",
        protein = "12g",
        carbs = "54g",
        fats = "23g"
    )

}