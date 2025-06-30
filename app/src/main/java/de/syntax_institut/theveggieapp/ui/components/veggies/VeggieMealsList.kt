package de.syntax_institut.theveggieapp.ui.components.veggies

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.syntax_institut.theveggieapp.data.remote.model.VeggieMeal

/**
 * A composable function that displays a list of veggie meals in a scrollable column.
 *
 * Each veggie meal is displayed using the [VeggieMealCard] composable.
 *
 * @param veggieMeals The list of [VeggieMeal] objects to be displayed.
 * @param modifier Modifier to be applied to the LazyColumn composable.
 * @param markVeggieMealAsFavorite A callback function to handle marking a meal as a favorite.
 */
@Composable
fun VeggieMealsList(
    veggieMeals: List<VeggieMeal>,
    modifier: Modifier = Modifier,
    markVeggieMealAsFavorite: (VeggieMeal) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(veggieMeals) { veggieMeal ->
            VeggieMealCard(veggieMeal = veggieMeal){
                markVeggieMealAsFavorite(veggieMeal)
            }
        }
    }
}

