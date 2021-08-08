package com.billyluisneedham.whatsinthefridge.ui.foodlist

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.billyluisneedham.whatsinthefridge.R
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.ui.theme.WhatsInTheFridgeTheme

@Composable
fun FoodListScreen(
    modifier: Modifier = Modifier,
    navigateToAddFoods: () -> Unit
) {
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
                .padding(8.dp),
            navigateToAddFoods = navigateToAddFoods
        )
    }

}

@Composable
fun FoodListContent(
    modifier: Modifier = Modifier,
    navigateToAddFoods: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.all_food),
            modifier = Modifier.weight(1f)
        )
        FoodCard(
            food = FoodMocks.foodInstanceMock,
            setQuantityOfFood = { quantity ->
               Log.d("FoodListContent", "setQuantityOfFood called with $quantity")
            }
        )
        Button(
            onClick = navigateToAddFoods
        ) {
            Text(text = "Navigate to Add Foods")
        }

    }
}

@Preview
@Composable
fun FoodListScreenPreview() {
    WhatsInTheFridgeTheme {
        FoodListScreen(navigateToAddFoods = {})
    }
}

