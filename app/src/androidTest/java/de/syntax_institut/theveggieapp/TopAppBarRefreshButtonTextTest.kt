package de.syntax_institut.theveggieapp

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TopAppBarRefreshButtonTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun refreshButton_displaysCorrectText() {

        // Setup
        composeTestRule.setContent { TheVeggieApp() }

        // Action
        composeTestRule.onNodeWithTag("RefreshButton").performClick()

        // Test
        composeTestRule.onNodeWithTag("VeggieCountText").assertTextContains("(40 Gerichte)")
    }
}