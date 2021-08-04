package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.model.FoodInstance
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme

@Composable
fun FoodListScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.all_food))
                }
            )
        }
    ) { innerPadding ->
        FoodListContent(modifier = Modifier
            .padding(innerPadding)
            .padding(8.dp))
    }
}

@Composable
fun FoodListContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = R.string.all_food))
    }
}

@Preview
@Composable
fun FoodListScreenPreview() {
    WhatsInTheFridgeTheme {
        FoodListScreen()
    }
}

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