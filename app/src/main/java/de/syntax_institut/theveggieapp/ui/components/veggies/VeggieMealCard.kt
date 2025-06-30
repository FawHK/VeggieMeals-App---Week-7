package de.syntax_institut.theveggieapp.ui.components.veggies

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import de.syntax_institut.theveggieapp.data.remote.model.VeggieMeal
import de.syntax_institut.theveggieapp.utils.StringHelper


/**
 * A composable function that displays a card for a veggie meal.
 *
 * The card includes an image, meal name, and an icon button to mark the meal as a favorite.
 *
 * @param modifier Modifier to be applied to the VeggieMealCard composable.
 * @param veggieMeal The [VeggieMeal] data model containing meal information.
 * @param markVeggieMealAsFavorite A callback function to handle marking the meal as a favorite.
 */
@Composable
fun VeggieMealCard(
    modifier: Modifier = Modifier,
    veggieMeal: VeggieMeal,
    markVeggieMealAsFavorite: (VeggieMeal) -> Unit
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = veggieMeal.strMealThumb,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = StringHelper.shortenText(veggieMeal.strMeal, 25),
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(12.dp)
                    .weight(1f)
            )
            Spacer(Modifier.width(8.dp))
            IconButton(onClick = {
                markVeggieMealAsFavorite(veggieMeal)
            },
                Modifier.testTag("FavoriteButton")
            ) {
                Icon(Icons.Default.AddCircle, Icons.Default.AddCircle.name)
            }
        }
    }
}