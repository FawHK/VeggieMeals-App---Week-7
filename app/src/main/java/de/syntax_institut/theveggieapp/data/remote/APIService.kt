package de.syntax_institut.theveggieapp.data.remote

import de.syntax_institut.theveggieapp.data.remote.model.VeggieMealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface for the API service that defines the endpoints for fetching veggie meals.
 *
 * This interface uses Retrofit to define the network request methods and their associated endpoints.
 */
interface APIService {
    /**
     * Fetches a list of veggie meals from the API based on the specified category.
     *
     * This function sends a GET request to the `filter.php` endpoint with the query parameter `c`
     * set to "Vegetarian" by default, but it can be customized with any category.
     *
     * @param category The category of meals to fetch (default is "Vegetarian").
     * @return A [VeggieMealsResponse] object containing the response data with the list of veggie meals.
     */

    @GET("filter.php")
    suspend fun getVeggieMeals(@Query("c") category: String = "Vegetarian"): VeggieMealsResponse
}