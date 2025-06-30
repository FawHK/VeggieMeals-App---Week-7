package de.syntax_institut.theveggieapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Abstract class representing the Room database for favorite meals.
 *
 * This class provides access to the [FavoritesDao] for performing database operations
 * on the `favorite_meals` table.
 *
 * @constructor Initializes the database with the given entities and version.
 */

@Database(entities = [FavoriteMeal::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase : RoomDatabase() {

    /**
     * Provides access to the DAO for performing operations on the `favorite_meals` table.
     */
    abstract fun dao(): FavoritesDao

    companion object {
        /**
         * Volatile variable to ensure thread safety for database instance.
         */
        @Volatile
        private var instance: FavoritesDatabase? = null

        /**
         * Returns the singleton instance of the [FavoritesDatabase].
         * If the database has not been initialized, it will create a new instance.
         *
         * @param context The application context used to build the database.
         * @return The singleton instance of [FavoritesDatabase].
         */
        fun getDatabase(context: Context): FavoritesDatabase {
            return instance ?: synchronized(this) {
                // Build the database and assign it to the instance
                Room.databaseBuilder(
                    context, FavoritesDatabase::class.java, "favorite_meals_db"
                ).build().also { instance = it }
            }
        }
    }
}