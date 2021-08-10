package com.billyluisneedham.whatsinthefridge.ui.foodlist

import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.util.timedisplayer.TimeDisplayer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FoodCardTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockFoodInstance = FoodMocks.foodInstanceMock

    private val mockTimeDisplayer = object : TimeDisplayer {
        override fun getCurrentTimeInMilliSeconds(): Long {
            return 0L
        }

        override fun getTimeDifferenceMessage(
            context: Context,
            firstTimeInMilliSeconds: Long,
            secondTimeInMilliSeconds: Long
        ): String {
            return "$secondTimeInMilliSeconds"
        }

        override fun getTimeDifferenceMessageBetweenNowAnd(
            timeInMilliSeconds: Long,
            context: Context
        ): String {
            return "$timeInMilliSeconds"
        }
    }

    private var mockFoodQuantity = 0
    private var mockDeleteFoodWithId = 0
    private lateinit var plusButtonContentDescription: String
    private lateinit var minusButtonContentDescription: String
    private lateinit var deleteButtonContentDescription: String

    @Before
    fun setUp() {
        mockFoodQuantity = 0
        mockDeleteFoodWithId = 0
        plusButtonContentDescription =
            InstrumentationRegistry.getInstrumentation().targetContext.getString(
                R.string.plus_quantity_content_description
            )
        minusButtonContentDescription =
            InstrumentationRegistry.getInstrumentation().targetContext.getString(
                R.string.minus_quantity_content_description
            )
        deleteButtonContentDescription = InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.delete_food_content_description)
    }

    @Test
    fun displaysNameByOnInit() {
        setUpTest()

        getFoodNameNode()
            .assertIsDisplayed()

    }

    private fun getFoodNameNode() =
        composeTestRule.onNodeWithText(text = mockFoodInstance.foodType.name)

    private fun setUpTest() {
        composeTestRule.setContent {
            FoodCard(
                food = mockFoodInstance,
                timeDisplayer = mockTimeDisplayer,
                setQuantityOfFood = { quantity ->
                    mockFoodQuantity = quantity
                },
                // TODO WRITE DELETE FUNCTION
            )
        }
    }


    @Test
    fun displaysTheResultOfATimeDisplayerOfTheExpiryTimeStampOfFoodInstanceOnInit() {
        setUpTest()

        composeTestRule.onNodeWithText(text = mockFoodInstance.expiryTimeStamp.toString())
            .assertIsDisplayed()
    }

    @Test
    fun displaysQuantityOfFoodOnClickOfCard() {
        setUpTest()


        getFoodQuantityNode()
            .assertDoesNotExist()

        getFoodNameNode()
            .performClick()

        getFoodQuantityNode()
            .assertExists()
    }

    private fun getFoodQuantityNode() =
        composeTestRule.onNodeWithText(text = mockFoodInstance.quantity.toString())

    @Test
    fun displaysPlusIconThatRunsSetQuantityOfFoodFunctionPassedByParamsWithPlusOneOfTheCurrentQuantity() {
        assertThat(mockFoodQuantity, `is`(0))
        setUpTest()


        getFoodNameNode()
            .performClick()

        composeTestRule.onNodeWithContentDescription(label = plusButtonContentDescription)
            .performClick()


        assertThat(mockFoodQuantity, `is`(mockFoodInstance.quantity + 1))

    }

    @Test
    fun displaysMinusIconThatRunsSetQuantityOfFoodFunctionPassedByParamsWithPlusOneOfTheCurrentQuantity() {
        assertThat(mockFoodQuantity, `is`(0))
        setUpTest()


        getFoodNameNode()
            .performClick()

        composeTestRule.onNodeWithContentDescription(label = minusButtonContentDescription)
            .performClick()


        assertThat(mockFoodQuantity, `is`(mockFoodInstance.quantity - 1))
    }

    @Test
    fun displaysDeleteIconThatRunsDeleteFoodFunctionPassedByParamsWithIdOfFoodInstanceIdAsParam() {
        assertThat(mockDeleteFoodWithId, `is`(0))
        setUpTest()


        composeTestRule.onNodeWithContentDescription(
            label =
            deleteButtonContentDescription
        ).performClick()


        assertThat(mockDeleteFoodWithId, `is`(mockFoodInstance.foodInstanceId))
    }

}