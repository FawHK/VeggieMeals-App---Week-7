package de.syntax_institut.theveggieapp.ui.components.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.syntax_institut.theveggieapp.data.local.FavoriteMeal

/**
 * A composable function that displays a list of favorite meals in a scrollable column.
 *
 * Each favorite meal is displayed using the [FavoriteMealCard] composable.
 *
 * @param favoriteMeals The list of [FavoriteMeal] objects to be displayed.
 * @param modifier Modifier to be applied to the LazyColumn composable.
 * @param deleteFavoriteMeal Callback function to handle the deletion of a favorite meal.
 */
@Composable
fun FavoriteMealsList(
    favoriteMeals: List<FavoriteMeal>,
    modifier: Modifier = Modifier,
    deleteFavoriteMeal: (FavoriteMeal) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(favoriteMeals) { favoriteMeal ->
            FavoriteMealCard(favoriteMeal = favoriteMeal){
                deleteFavoriteMeal(favoriteMeal)
            }
        }
    }
}

