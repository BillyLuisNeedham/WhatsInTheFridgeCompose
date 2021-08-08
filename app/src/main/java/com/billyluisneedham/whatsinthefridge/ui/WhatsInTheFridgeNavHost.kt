package com.billyluisneedham.whatsinthefridge.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import com.billyluisneedham.whatsinthefridge.ui.addfood.AddFoodScreen
import com.billyluisneedham.whatsinthefridge.ui.foodlist.FoodListScreen

@Composable
fun WhatsInTheFridgeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.FoodList.name,
        modifier = modifier
    ) {
        composable(route = Screens.FoodList.name) {
            FoodListScreen(
                navigateToAddFoods = { navController.navigate(Screens.AddFood.name) },
                // TODO REPLACE WITH PROPER DATA
                foodsList = listOf(FoodMocks.foodInstanceMock)
            )
        }
        composable(route = Screens.AddFood.name) {
            AddFoodScreen(onBack = onBack)
        }
    }
}