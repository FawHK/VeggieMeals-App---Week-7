package de.syntax_institut.theveggieapp.ui.components.navigation

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import de.syntax_institut.theveggieapp.data.navigation.NavigationItem

/**
 * A composable function that displays a customizable bottom navigation bar.
 *
 * The navigation bar supports displaying navigation items with badges for the Favorites tab.
 *
 * @param navItems A list of [NavigationItem] objects representing the navigation options.
 * @param onNavItemSelection Callback function invoked when a navigation item is selected.
 * @param selectedNavItem The currently selected [NavigationItem].
 * @param favoritesCount The count of favorite items to be displayed as a badge.
 */
@Composable
fun BottomNavigationBar(
    navItems: List<NavigationItem>,
    onNavItemSelection: (NavigationItem) -> Unit,
    selectedNavItem: NavigationItem,
    favoritesCount: Int
) {
    NavigationBar {
        navItems.forEach { navItem ->
            NavigationBarItem(
                selected = selectedNavItem == navItem,
                onClick = { onNavItemSelection(navItem) },
                icon = {
                    BadgedBox(
                        badge = {
                            if (navItem == NavigationItem.Favorites && favoritesCount > 0) {
                                Badge {
                                    Text(favoritesCount.toString(), Modifier.testTag(navItem.label))
                                }
                            }
                        }
                    ) {
                        Icon(navItem.icon, contentDescription = navItem.label)
                    }
                },
                label = { Text(navItem.label) }
            )
        }
    }
}
