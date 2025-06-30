package de.syntax_institut.theveggieapp.data.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Enum class representing navigation items in the app.
 *
 * Each enum constant corresponds to a screen in the app and includes the associated route, label, and icon.
 *
 * @property route The route for the screen, typically a string or route identifier.
 * @property label The label to be displayed for the navigation item.
 * @property icon The icon representing the navigation item, usually from the Material Icons set.
 */
enum class NavigationItem(
    val route: Any,
    val label: String,
    val icon: ImageVector
) {
    VeggieList(
        route = VeggieScreenRoute,
        label = "Veggie Gerichte",
        icon = Icons.Default.Fastfood
    ),
    Favorites(
        route = FavoritesScreenRoute,
        label = "Favoriten",
        icon = Icons.Default.Favorite
    )
}