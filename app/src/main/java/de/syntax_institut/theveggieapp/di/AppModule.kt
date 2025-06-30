package de.syntax_institut.theveggieapp.di

import de.syntax_institut.theveggieapp.data.local.FavoritesDatabase
import de.syntax_institut.theveggieapp.data.remote.VeggieMealAPI
import de.syntax_institut.theveggieapp.data.repository.FavoritesMealsRepoImpl
import de.syntax_institut.theveggieapp.data.repository.FavoritesMealsRepoInterface
import de.syntax_institut.theveggieapp.data.repository.VeggieMealRepoImpl
import de.syntax_institut.theveggieapp.data.repository.VeggieMealRepoInterface
import de.syntax_institut.theveggieapp.viewModel.VeggieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * The Koin module that provides dependency definitions for the app.
 *
 * This module includes definitions for database instances, repositories, and view models.
 */
val appModule = module {

    /**
     * Provides a singleton instance of the [FavoritesDatabase].
     */
    single {
        FavoritesDatabase.getDatabase(androidContext())
    }

    /**
     * Provides a singleton instance of the DAO from the [FavoritesDatabase].
     */
    single {
        get<FavoritesDatabase>().dao()
    }

    /**
     * Provides a singleton implementation of the [VeggieMealRepoInterface].
     *
     * The default implementation used is [VeggieMealRepoImpl] with a remote API service.
     * Uncomment the `FakeVeggiesRepoImpl` line for testing purposes.
     */
    single<VeggieMealRepoInterface> {
        VeggieMealRepoImpl(VeggieMealAPI.retrofitService)
//        FakeVeggiesRepoImpl()
    }

    /**
     * Provides a singleton implementation of the [FavoritesMealsRepoInterface].
     */
    single<FavoritesMealsRepoInterface> {
        FavoritesMealsRepoImpl(get())
    }

    /**
     * Provides a [VeggieViewModel] instance through Koin.
     */
    viewModelOf(::VeggieViewModel)
}