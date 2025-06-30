package de.syntax_institut.theveggieapp.data

import de.syntax_institut.theveggieapp.data.local.FavoriteMeal
import de.syntax_institut.theveggieapp.data.remote.model.VeggieMeal

const val PLACEHOLDER_NAME = "Kartoffelsalat"
const val PLACEHOLDER_URL = "https://www.themealdb.com/images/media/meals/ebvuir1699013665.jpg"

val PLACEHOLDER_VEGGIE_MEALS = listOf(
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL),
    VeggieMeal(strMeal = PLACEHOLDER_NAME, strMealThumb = PLACEHOLDER_URL)
)

val PLACEHOLDER_FAVORITE_MEALS = listOf(
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL),
    FavoriteMeal(mealName = PLACEHOLDER_NAME, mealImageURL = PLACEHOLDER_URL)
)