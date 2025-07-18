package de.syntax_institut.theveggieapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.syntax_institut.theveggieapp.data.navigation.FavoritesScreenRoute
import de.syntax_institut.theveggieapp.data.navigation.NavigationItem
import de.syntax_institut.theveggieapp.data.navigation.VeggieScreenRoute
import de.syntax_institut.theveggieapp.ui.components.navigation.BottomNavigationBar
import de.syntax_institut.theveggieapp.ui.screens.favoritesScreen.FavoritesScreen
import de.syntax_institut.theveggieapp.ui.screens.veggieScreen.VeggieScreen
import de.syntax_institut.theveggieapp.viewModel.VeggieViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheVeggieApp() {
    val mealViewModel: VeggieViewModel = koinViewModel()
    val veggieMeals by mealViewModel.veggieMealsState.collectAsState()
    val favoriteMeals by mealViewModel.getAllFavoriteMeals().collectAsState()
    val navController = rememberNavController()
    var selectedNavigationItem by rememberSaveable { mutableStateOf(NavigationItem.VeggieList) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("The Veggie App")
                        Spacer(Modifier.weight(1f))
                        Text(
                            text ="(${veggieMeals.size} Gerichte)",
                            fontSize = 10.sp,
                            modifier = Modifier.testTag("VeggieCountText")
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            mealViewModel.getVeggieMeals()
                        },
                        modifier = Modifier.testTag("RefreshButton")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = Icons.Default.Refresh.name,
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = selectedNavigationItem.route
            ) {
                composable<VeggieScreenRoute> {
                    VeggieScreen(
                        veggieVeggieMeals = veggieMeals,
                        markVeggieMealAsFavorite = { veggieMeal ->
                            mealViewModel.markVeggieMealAsFavorite(veggieMeal)
                        },
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()

                    )
                }
                composable<FavoritesScreenRoute> {
                    FavoritesScreen(
                        favoriteVeggieMeals = favoriteMeals,
                        removeFavoriteMeal = { favoriteMeal ->
                            mealViewModel.removeFavoriteMeal(favoriteMeal)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navItems = NavigationItem.entries,
                onNavItemSelection = {
                    selectedNavigationItem = it
                },
                selectedNavItem = selectedNavigationItem,
                favoritesCount = favoriteMeals.size
            )
        }
    )
}

