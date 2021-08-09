package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.domain.model.FoodInstance
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme

@Composable
fun FoodListScreen(
    modifier: Modifier = Modifier,
    navigateToAddFoods: () -> Unit,
    foodsList: List<FoodInstance>?
) {
    val smallPadding = dimensionResource(id = R.dimen.padding_small)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.all_food))
                }
            )
        }
    ) { innerPadding ->
        FoodListContent(
            modifier = modifier
                .padding(innerPadding)
                .padding(smallPadding),
            navigateToAddFoods = navigateToAddFoods,
            foodsList = foodsList 
        )
    }

}

@Composable
fun FoodListContent(
    modifier: Modifier = Modifier,
    navigateToAddFoods: () -> Unit,
    foodsList: List<FoodInstance>?
) {
    foodsList?.let {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = foodsList) { food ->
                FoodCard(food = food, setQuantityOfFood = {})
            }
        }
    }
}

@Preview
@Composable
fun FoodListScreenPreview() {
    WhatsInTheFridgeTheme {
        FoodListScreen(
            navigateToAddFoods = {},
            foodsList = listOf(FoodMocks.foodInstanceMock)
        )
    }
}

