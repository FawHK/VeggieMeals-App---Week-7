package de.syntax_institut.theveggieapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.theveggieapp.data.local.FavoriteMeal
import de.syntax_institut.theveggieapp.data.remote.model.VeggieMeal
import de.syntax_institut.theveggieapp.data.repository.FavoritesMealsRepoInterface
import de.syntax_institut.theveggieapp.data.repository.VeggieMealRepoInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VeggieViewModel(
    application: Application,
    private val veggieMealRepo: VeggieMealRepoInterface,
    private val favoritesMealsRepo: FavoritesMealsRepoInterface,
) : AndroidViewModel(application) {
    // Properties ---------------------------------------------------------------
    private val _veggieMealsState = MutableStateFlow<List<VeggieMeal>>(listOf())
    val veggieMealsState = _veggieMealsState.asStateFlow()


    // Initialisations ---------------------------------------------------------
    init {
        getVeggieMeals()
    }

    // Functions ----------------------------------------------------------------
    fun getVeggieMeals() {
        viewModelScope.launch {
            try {
                val veggieMealsResponse = veggieMealRepo.getVeggieMeals()
                _veggieMealsState.value = veggieMealsResponse.meals.shuffled()
            } catch (e: Exception) {
                Log.e("ERROR", "Error getting veggie meals ${e.localizedMessage}")
            }
        }
    }

    fun markVeggieMealAsFavorite(veggieMeal: VeggieMeal) {
        viewModelScope.launch {
            try {
                val favoriteMeal = convertVeggieMealToFavoriteMeal(veggieMeal)
               favoritesMealsRepo.insertFavoriteMeal(favoriteMeal = favoriteMeal)
            } catch (e: Exception) {
                Log.e("ERROR", "Error while trying to insert favorite meal ${e.localizedMessage}")
            }
        }
    }

    fun getAllFavoriteMeals(): StateFlow<List<FavoriteMeal>> {
        return favoritesMealsRepo.getAllVeggieMeals().stateIn(
            initialValue = listOf(),
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed()
        )
    }

    fun removeFavoriteMeal(favoriteMeal: FavoriteMeal) {
        viewModelScope.launch {
            try {
                favoritesMealsRepo.deleteMeal(favoriteMeal)
            } catch (e: Exception) {
                Log.e("ERROR", "Error while trying to delete favorite meal ${e.localizedMessage}")
            }
        }
    }

    private fun convertVeggieMealToFavoriteMeal(veggieMeal: VeggieMeal): FavoriteMeal {
        return FavoriteMeal(
            idMeal = veggieMeal.idMeal.toInt(),
            mealName = veggieMeal.strMeal,
            mealImageURL = veggieMeal.strMealThumb
        )
    }
}