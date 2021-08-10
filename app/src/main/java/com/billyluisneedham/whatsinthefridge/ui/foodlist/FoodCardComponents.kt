package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.domain.model.FoodInstance
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme
import com.billyluisneedham.whatsinthefridge.util.timedisplayer.TimeDisplayer
import com.billyluisneedham.whatsinthefridge.util.timedisplayer.TimeDisplayerImpl

const val FOOD_CARD_TEST_TAG = "food_card_test_tag"

@Composable
fun FoodCard(
    modifier: Modifier = Modifier,
    food: FoodInstance,
    timeDisplayer: TimeDisplayer = TimeDisplayerImpl,
    setQuantityOfFood: (Int) -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }
    val paddingSmall = dimensionResource(id = R.dimen.padding_small)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag(FOOD_CARD_TEST_TAG)
    ) {
        Surface(
            modifier = Modifier
                .animateContentSize()
                .fillMaxWidth()

        ) {
            Column(
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
                    .fillMaxWidth()
            ) {
                FoodCardTopRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingSmall),
                    food = food,
                    timeDisplayer = timeDisplayer
                )
                if (isExpanded) FoodCardBottomRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingSmall),
                    food = food,
                    setQuantityOfFood = setQuantityOfFood
                )

            }
        }
    }
}

@Composable
private fun FoodCardTopRow(
    modifier: Modifier = Modifier,
    food: FoodInstance,
    timeDisplayer: TimeDisplayer
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = food.foodType.name)
        Text(
            text = timeDisplayer.getTimeDifferenceMessageBetweenNowAnd(
                timeInMilliSeconds = food.expiryTimeStamp,
                context = LocalContext.current
            )
        )
    }
}

@Composable
private fun FoodCardBottomRow(
    modifier: Modifier = Modifier,
    food: FoodInstance,
    setQuantityOfFood: (Int) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = food.quantity.toString())
        PlusMinusButtons(
            onClickPlus = { setQuantityOfFood(food.quantity + 1) },
            onClickMinus = { setQuantityOfFood(food.quantity - 1) }
        )

    }
}

@Composable
fun PlusMinusButtons(
    modifier: Modifier = Modifier,
    onClickPlus: () -> Unit,
    onClickMinus: () -> Unit
) {
    Row(modifier = modifier) {
        IconButton(onClick = onClickPlus) {
            Icon(
                Icons.Filled.AddCircle,
                contentDescription = stringResource(id = R.string.plus_quantity_content_description)
            )
        }
        IconButton(onClick = onClickMinus) {
            Icon(
                Icons.Filled.RemoveCircle,
                contentDescription = stringResource(id = R.string.minus_quantity_content_description)
            )
        }
    }
}

@Preview
@Composable
fun FoodCardBottomRowPreview() {
    WhatsInTheFridgeTheme {
        Surface {
            FoodCardBottomRow(
                modifier = Modifier.fillMaxWidth(),
                food = FoodMocks.foodInstanceMock,
                setQuantityOfFood = { quantity -> }
            )
        }
    }
}

@Preview
@Composable
fun FoodCardPreview() {
    val foodInstance = FoodMocks.foodInstanceMock

    WhatsInTheFridgeTheme {
        FoodCard(food = foodInstance, setQuantityOfFood = { quantity -> })
    }
}