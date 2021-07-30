package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.model.FoodInstance
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme


@Composable
fun FoodCard(modifier: Modifier = Modifier, food: FoodInstance) {
    Card {
        Text(text = food.foodType.name)
    }
}

@Preview
@Composable
fun FoodCardPreview() {
    val foodInstance = FoodMocks.foodInstanceMock

    WhatsInTheFridgeTheme {
        FoodCard(food = foodInstance)
    }
}