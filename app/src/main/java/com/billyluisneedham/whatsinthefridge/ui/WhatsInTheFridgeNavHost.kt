package com.billyluisneedham.whatsinthefridge.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.billyluisneedham.whatsinthefridge.ui.addfood.AddFoodScreen
import com.billyluisneedham.whatsinthefridge.ui.foodlist.FoodListScreen

@Composable
fun WhatsInTheFridgeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    mainViewModel: MainViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.FoodList.name,
        modifier = modifier
    ) {
        composable(route = Screens.FoodList.name) {
            FoodListScreen(
                navigateToAddFoods = { navController.navigate(Screens.AddFood.name) },
                mainViewModel = mainViewModel
                            )
        }
        composable(route = Screens.AddFood.name) {
            AddFoodScreen(onBack = onBack)
        }
    }
}