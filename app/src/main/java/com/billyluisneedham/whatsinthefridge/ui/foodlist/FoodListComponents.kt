package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.domain.model.FoodInstance
import com.billyluisneedham.whatsinthefridge.ui.MainViewModel
import com.billyluisneedham.whatsinthefridge.domain.Result

@Composable
fun FoodListScreen(
    modifier: Modifier = Modifier,
    navigateToAddFoods: () -> Unit,
    mainViewModel: MainViewModel
) {
    val smallPadding = dimensionResource(id = R.dimen.padding_small)
    val foodsList = remember {
        mutableStateOf(mainViewModel.foodList.value)
    }

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
            foodsList = foodsList.component1()
        )
    }

}

@Composable
fun FoodListContent(
    modifier: Modifier = Modifier,
    navigateToAddFoods: () -> Unit,
    foodsList: Result<List<FoodInstance>>
) {
    when (foodsList) {
        is Result.Error -> TODO()
        Result.Loading -> TODO()
        is Result.Success -> FoodList(modifier = modifier, foodsList = foodsList.data)
    }


}

@Composable
private fun FoodList(
    modifier: Modifier = Modifier,
    foodsList: List<FoodInstance>
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = foodsList) { food ->
            FoodCard(food = food, setQuantityOfFood = {})
        }
    }
}

@Preview
@Composable
fun FoodListPreview() {
    FoodList(foodsList = listOf(FoodMocks.foodInstanceMock))
}

