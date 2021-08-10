package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class FoodListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val mockFoodsList = listOf(FoodMocks.foodInstanceMock)

    @Test
    fun mapsAListOfFoodInstancesPassedByParamsToFoodCardsOnInit() {
        composeTestRule.setContent {
            FoodListScreen(
                navigateToAddFoods = {},
                foodsList = mockFoodsList
            )
        }


        composeTestRule.onNodeWithText(mockFoodsList[0].foodType.name).assertExists()
        composeTestRule.onNodeWithTag(FOOD_CARD_TEST_TAG).assertExists()

    }
}