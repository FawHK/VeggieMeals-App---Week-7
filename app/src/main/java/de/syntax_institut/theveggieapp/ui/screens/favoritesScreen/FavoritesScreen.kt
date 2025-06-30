package de.syntax_institut.theveggieapp.ui.screens.favoritesScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.syntax_institut.theveggieapp.data.local.FavoriteMeal
import de.syntax_institut.theveggieapp.ui.components.favorites.FavoriteMealsList

/**
 * A composable function that represents the favorites screen of the app.
 *
 * The screen displays a list of favorite meals using the [FavoriteMealsList] composable.
 *
 * @param modifier Modifier to be applied to the root container of the screen.
 * @param favoriteVeggieMeals The list of [FavoriteMeal] objects representing the user's favorite meals.
 * @param removeFavoriteMeal Callback function to handle the removal of a favorite meal.
 */
@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    favoriteVeggieMeals: List<FavoriteMeal>,
    removeFavoriteMeal: (FavoriteMeal) -> Unit
) {
    Box(modifier = modifier) {
        FavoriteMealsList(
            favoriteMeals = favoriteVeggieMeals,
            deleteFavoriteMeal = removeFavoriteMeal
        )
    }
}