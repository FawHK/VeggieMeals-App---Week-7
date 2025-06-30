package de.syntax_institut.theveggieapp.data.repository

import de.syntax_institut.theveggieapp.data.PLACEHOLDER_VEGGIE_MEALS
import de.syntax_institut.theveggieapp.data.remote.model.VeggieMealsResponse

/**
 * A fake implementation of the [VeggieMealRepoInterface] used for testing purposes.
 *
 * This class simulates fetching veggie meals by returning a predefined list of placeholder veggie meals.
 * It is typically used when no actual network call or database access is needed (e.g., for unit tests).
 */
class FakeVeggiesRepoImpl: VeggieMealRepoInterface {
    /**
     * Simulates fetching veggie meals by returning a predefined list of placeholder veggie meals.
     *
     * @return A [VeggieMealsResponse] containing a list of placeholder veggie meals.
     */
    override suspend fun getVeggieMeals(): VeggieMealsResponse {
        return VeggieMealsResponse(PLACEHOLDER_VEGGIE_MEALS)
    }
}