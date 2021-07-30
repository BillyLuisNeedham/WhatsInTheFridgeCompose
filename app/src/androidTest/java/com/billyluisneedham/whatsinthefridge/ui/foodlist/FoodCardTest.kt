package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme
import org.junit.Rule
import org.junit.Test

class FoodCardTest {

    private val mockFoodInstance = FoodMocks.foodInstanceMock

    @get:Rule
    val compostTestRule = createComposeRule()

    @Test
    fun foodCardDisplaysNameByDefault() {
        compostTestRule.setContent {
            WhatsInTheFridgeTheme {
                FoodCard(
                    food = mockFoodInstance
                )
            }
        }

        compostTestRule.onNodeWithText(text = mockFoodInstance.foodType.name).assertIsDisplayed()
    }


}