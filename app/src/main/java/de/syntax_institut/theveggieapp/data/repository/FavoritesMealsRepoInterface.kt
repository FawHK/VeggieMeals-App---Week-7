package de.syntax_institut.theveggieapp.data.repository

import de.syntax_institut.theveggieapp.data.local.FavoriteMeal
import de.syntax_institut.theveggieapp.data.local.FavoritesDao
import kotlinx.coroutines.flow.Flow

/**
 * Interface for the repository that provides access to favorite meals data.
 *
 * This interface defines methods for inserting, updating, deleting, and retrieving favorite meals.
 */
interface FavoritesMealsRepoInterface {

    /**
     * Inserts a new favorite meal into the database.
     *
     * @param favoriteMeal The [FavoriteMeal] to be inserted into the database.
     */
    suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal)

    /**
     * Updates an existing favorite meal in the database.
     *
     * @param favoriteMeal The [FavoriteMeal] to be updated.
     */
    suspend fun updateMeal(favoriteMeal: FavoriteMeal)

    /**
     * Deletes all favorite meals from the database.
     */
    suspend fun deleteAll()

    /**
     * Deletes a specific favorite meal from the database.
     *
     * @param favoriteMeal The [FavoriteMeal] to be deleted.
     */
    suspend fun deleteMeal(favoriteMeal: FavoriteMeal)

    /**
     * Retrieves all favorite meals from the database as a [Flow] of a list of [FavoriteMeal].
     *
     * @return A flow of list of [FavoriteMeal] objects.
     */
    fun getAllVeggieMeals(): Flow<List<FavoriteMeal>>
}


/**
 * Implementation of the [FavoritesMealsRepoInterface] that interacts with the [FavoritesDao].
 *
 * This class provides the concrete implementation of the repository methods by delegating the database
 * operations to the [FavoritesDao].
 *
 * @param favoritesDao The [FavoritesDao] used for performing database operations.
 */

class FavoritesMealsRepoImpl(
    private val favoritesDao: FavoritesDao
) : FavoritesMealsRepoInterface {

    /**
     * Inserts a new favorite meal into the database using the [FavoritesDao].
     *
     * @param favoriteMeal The [FavoriteMeal] to be inserted.
     */
    override suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal) {
        favoritesDao.insertFavoriteMeal(favoriteMeal)
    }

    /**
     * Updates an existing favorite meal in the database using the [FavoritesDao].
     *
     * @param favoriteMeal The [FavoriteMeal] to be updated.
     */
    override suspend fun updateMeal(favoriteMeal: FavoriteMeal) {
        favoritesDao.updateMeal(favoriteMeal)
    }

    /**
     * Deletes all favorite meals from the database using the [FavoritesDao].
     */
    override suspend fun deleteAll() {
        favoritesDao.deleteAll()
        }

    /**
     * Deletes a specific favorite meal from the database using the [FavoritesDao].
     *
     * @param favoriteMeal The [FavoriteMeal] to be deleted.
     */
    override suspend fun deleteMeal(favoriteMeal: FavoriteMeal) {
        favoritesDao.deleteMeal(favoriteMeal)
    }

    /**
     * Retrieves all favorite meals from the database as a flow of list of [FavoriteMeal].
     *
     * @return A flow of list of [FavoriteMeal] objects from the [FavoritesDao].
     */
    override fun getAllVeggieMeals(): Flow<List<FavoriteMeal>> {
        return favoritesDao.getAllVeggieMeals()
    }
}

