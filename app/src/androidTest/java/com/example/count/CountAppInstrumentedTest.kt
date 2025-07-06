package com.example.count

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountAppInstrumentedTest {
    
    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.count", appContext.packageName)
    }
    
    @Test
    fun counterScreen_initialState_displaysZero() {
        composeTestRule.setContent {
            CountButtonScreen()
        }
        
        composeTestRule.onNodeWithText("Count: 0").assertIsDisplayed()
        composeTestRule.onNodeWithText("+").assertIsDisplayed()
        composeTestRule.onNodeWithText("-").assertIsDisplayed()
        composeTestRule.onNodeWithText("Reset").assertIsDisplayed()
    }
    
    @Test
    fun plusButton_whenClicked_incrementsCounter() {
        composeTestRule.setContent {
            CountButtonScreen()
        }
        
        // Initial state
        composeTestRule.onNodeWithText("Count: 0").assertIsDisplayed()
        
        // Click plus button
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("Count: 1").assertIsDisplayed()
        
        // Click plus button again
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("Count: 2").assertIsDisplayed()
    }
    
    @Test
    fun minusButton_whenClicked_decrementsCounter() {
        composeTestRule.setContent {
            CountButtonScreen()
        }
        
        // First increment to 3
        repeat(3) {
            composeTestRule.onNodeWithText("+").performClick()
        }
        composeTestRule.onNodeWithText("Count: 3").assertIsDisplayed()
        
        // Click minus button
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("Count: 2").assertIsDisplayed()
        
        // Click minus button again
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("Count: 1").assertIsDisplayed()
    }
    
    @Test
    fun minusButton_atZero_doesNotGoBelowZero() {
        composeTestRule.setContent {
            CountButtonScreen()
        }
        
        // Initial state is 0
        composeTestRule.onNodeWithText("Count: 0").assertIsDisplayed()
        
        // Click minus button - should stay at 0
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("Count: 0").assertIsDisplayed()
    }
    
    @Test
    fun resetButton_whenClicked_resetsToZero() {
        composeTestRule.setContent {
            CountButtonScreen()
        }
        
        // Increment to 5
        repeat(5) {
            composeTestRule.onNodeWithText("+").performClick()
        }
        composeTestRule.onNodeWithText("Count: 5").assertIsDisplayed()
        
        // Click reset
        composeTestRule.onNodeWithText("Reset").performClick()
        composeTestRule.onNodeWithText("Count: 0").assertIsDisplayed()
    }
    
    @Test
    fun complexInteraction_multipleButttonClicks() {
        composeTestRule.setContent {
            CountButtonScreen()
        }
        
        // Start at 0
        composeTestRule.onNodeWithText("Count: 0").assertIsDisplayed()
        
        // Increment to 3
        repeat(3) {
            composeTestRule.onNodeWithText("+").performClick()
        }
        composeTestRule.onNodeWithText("Count: 3").assertIsDisplayed()
        
        // Decrement to 1
        repeat(2) {
            composeTestRule.onNodeWithText("-").performClick()
        }
        composeTestRule.onNodeWithText("Count: 1").assertIsDisplayed()
        
        // Increment to 4
        repeat(3) {
            composeTestRule.onNodeWithText("+").performClick()
        }
        composeTestRule.onNodeWithText("Count: 4").assertIsDisplayed()
        
        // Reset to 0
        composeTestRule.onNodeWithText("Reset").performClick()
        composeTestRule.onNodeWithText("Count: 0").assertIsDisplayed()
        
        // Try to go below 0
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("Count: 0").assertIsDisplayed()
    }
}