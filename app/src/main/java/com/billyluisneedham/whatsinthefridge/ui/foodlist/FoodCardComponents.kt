package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.model.FoodInstance
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme
import com.billyluisneedham.whatsinthefridge.util.timedisplayer.TimeDisplayer
import com.billyluisneedham.whatsinthefridge.util.timedisplayer.TimeDisplayerImpl

@Composable
fun FoodCard(
    modifier: Modifier = Modifier,
    food: FoodInstance,
    timeDisplayer: TimeDisplayer = TimeDisplayerImpl,
    setQuantityOfFood: (Int) -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Surface(
            modifier = Modifier
                .animateContentSize()
                .fillMaxWidth()
                .padding(1.dp)

        ) {
            Column(
                Modifier
                    .clickable { isExpanded = !isExpanded }
                    .fillMaxWidth()
            ) {
                FoodCardTopRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    food = food,
                    timeDisplayer = timeDisplayer
                )
                if (isExpanded) FoodCardBottomRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    food = food
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
private fun FoodCardBottomRow(modifier: Modifier = Modifier, food: FoodInstance) {
    Row(modifier = modifier) {
        Text(text = food.quantity.toString())
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