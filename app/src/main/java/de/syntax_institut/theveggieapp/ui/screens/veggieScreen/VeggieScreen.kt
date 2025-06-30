package de.syntax_institut.theveggieapp.ui.screens.veggieScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.syntax_institut.theveggieapp.data.remote.model.VeggieMeal
import de.syntax_institut.theveggieapp.ui.components.veggies.VeggieMealsList

/**
 * A composable function that represents the veggie meals screen of the app.
 *
 * The screen displays a list of veggie meals using the [VeggieMealsList] composable.
 *
 * @param modifier Modifier to be applied to the root container of the screen.
 * @param veggieVeggieMeals The list of [VeggieMeal] objects representing veggie meal options.
 * @param markVeggieMealAsFavorite Callback function to handle marking a veggie meal as a favorite.
 */
@Composable
fun VeggieScreen(
    modifier: Modifier = Modifier,
    veggieVeggieMeals: List<VeggieMeal>,
    markVeggieMealAsFavorite: (VeggieMeal) -> Unit
) {
    Box(modifier = modifier) {
        VeggieMealsList(veggieVeggieMeals) { meal ->
            markVeggieMealAsFavorite(meal)
        }
    }
}