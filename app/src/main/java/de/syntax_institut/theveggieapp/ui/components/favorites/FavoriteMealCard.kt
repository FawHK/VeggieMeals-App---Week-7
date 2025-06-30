package de.syntax_institut.theveggieapp.ui.components.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import de.syntax_institut.theveggieapp.data.local.FavoriteMeal

/**
 * A composable function that displays a card for a favorite meal.
 *
 * The card includes an image, meal name, and an icon button to remove the meal from favorites.
 *
 * @param modifier Modifier to be applied to the FavoriteMealCard composable.
 * @param favoriteMeal The [FavoriteMeal] data model containing information about the favorite meal.
 * @param markVeggieMealAsFavorite A callback function to handle removing the meal from favorites.
 */
@Composable
fun FavoriteMealCard(
    modifier: Modifier = Modifier,
    favoriteMeal: FavoriteMeal,
    markVeggieMealAsFavorite: (FavoriteMeal) -> Unit
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Column {
            AsyncImage(
                model = favoriteMeal.mealImageURL,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(96.dp)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(Modifier.width(8.dp))
                Text(
                    text = favoriteMeal.mealName,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(12.dp)
                        .weight(1f)
                )
                Spacer(Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        markVeggieMealAsFavorite(favoriteMeal)
                    }
                ) {
                    Icon(Icons.Default.Delete, Icons.Default.Delete.name)
                }
            }
        }
    }
}
