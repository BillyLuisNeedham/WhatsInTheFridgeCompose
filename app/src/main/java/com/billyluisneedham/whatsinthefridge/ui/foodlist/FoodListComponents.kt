package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.billyluisneedham.whatsinthefridge.model.FoodInstance

@Composable
fun FoodCard(food: FoodInstance) {
    Text(text = food.foodType.name)
}