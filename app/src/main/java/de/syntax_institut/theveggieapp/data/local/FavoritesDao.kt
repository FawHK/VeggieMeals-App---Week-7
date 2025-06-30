package de.syntax_institut.theveggieapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * DAO (Data Access Object) interface for accessing the `favorite_meals` table in the database.
 *
 * This interface defines methods for inserting, updating, deleting, and querying favorite meals.
 */
@Dao
interface FavoritesDao {

    /**
     * Inserts a favorite meal into the `favorite_meals` table. If the meal already exists, it will be aborted.
     *
     * @param favoriteMeal The [FavoriteMeal] object to be inserted.
     */

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFavoriteMeal(favoriteMeal: FavoriteMeal)

    /**
     * Updates an existing favorite meal in the `favorite_meals` table.
     *
     * @param favoriteMeal The [FavoriteMeal] object to be updated.
     */

    @Update
    suspend fun updateMeal(favoriteMeal: FavoriteMeal)

    /**
     * Deletes all favorite meals from the `favorite_meals` table.
     */

    @Query("DELETE FROM favorite_meals")
    suspend fun deleteAll()

    /**
     * Deletes a specific favorite meal from the `favorite_meals` table.
     *
     * @param favoriteMeal The [FavoriteMeal] object to be deleted.
     */

    @Delete
    suspend fun deleteMeal(favoriteMeal: FavoriteMeal)

    /**
     * Retrieves all favorite meals from the `favorite_meals` table as a flow of list of [FavoriteMeal].
     *
     * @return A flow of list of all [FavoriteMeal] objects.
     */

    @Query("SELECT * FROM favorite_meals")
    fun getAllVeggieMeals(): Flow<List<FavoriteMeal>>
}