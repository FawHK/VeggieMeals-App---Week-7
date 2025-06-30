package de.syntax_institut.theveggieapp.data.repository

import de.syntax_institut.theveggieapp.data.remote.APIService
import de.syntax_institut.theveggieapp.data.remote.model.VeggieMealsResponse

/**
 * Interface for the repository that provides access to veggie meal data.
 *
 * This interface defines methods for fetching veggie meals from an API or another data source.
 */
interface VeggieMealRepoInterface {

    /**
     * Fetches a list of veggie meals from the data source.
     *
     * @return A [VeggieMealsResponse] containing the list of veggie meals.
     */
    suspend fun getVeggieMeals(): VeggieMealsResponse
}


/**
 * Implementation of the [VeggieMealRepoInterface] that interacts with the [APIService].
 *
 * This class provides the concrete implementation of the repository method by delegating the network
 * request to the [APIService].
 *
 * @param apiService The [APIService] used to make network requests to fetch veggie meals.
 */
class VeggieMealRepoImpl(
    private val apiService: APIService
) : VeggieMealRepoInterface {

    /**
     * Fetches a list of veggie meals from the [APIService].
     *
     * @return A [VeggieMealsResponse] containing the list of veggie meals retrieved from the API.
     */
    override suspend fun getVeggieMeals(): VeggieMealsResponse {
        return apiService.getVeggieMeals()
    }
}
