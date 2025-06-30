package de.syntax_institut.theveggieapp.data.remote.model

/**
 * Data class representing a veggie meal.
 *
 * This class is used to model an individual veggie meal, containing details such as the meal's ID,
 * name, and image URL.
 *
 * @property idMeal The unique identifier for the meal.
 * @property strMeal The name or title of the meal.
 * @property strMealThumb The URL of the meal's thumbnail image.
 */
data class VeggieMeal(
    val idMeal: String = "",
    val strMeal: String = "",
    val strMealThumb: String = ""
)