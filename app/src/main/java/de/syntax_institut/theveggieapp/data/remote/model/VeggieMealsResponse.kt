package de.syntax_institut.theveggieapp.data.remote.model

/**
 * Data class representing the response from the API containing a list of veggie meals.
 *
 * This class is used to model the data returned by the API when fetching veggie meals. It contains a
 * list of [VeggieMeal] objects.
 *
 * @property meals A list of [VeggieMeal] objects, each representing a single veggie meal.
 */
data class VeggieMealsResponse(
    val meals: List<VeggieMeal>
)
