package de.syntax_institut.theveggieapp

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import de.syntax_institut.theveggieapp.data.navigation.NavigationItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FavoritesButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun favoritesButton() {

        // Setup
        composeTestRule.setContent { TheVeggieApp() }

        // Action
        composeTestRule.onAllNodesWithTag("FavoriteButton")
            .onFirst()
            .performClick()

        // Test
        composeTestRule
            .onNodeWithTag(testTag = NavigationItem.Favorites.label, useUnmergedTree = true).assertTextContains("1")
    }
}