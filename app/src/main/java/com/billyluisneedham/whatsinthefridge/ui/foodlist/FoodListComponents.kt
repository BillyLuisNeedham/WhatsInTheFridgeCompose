package com.billyluisneedham.whatsinthefridge.ui.foodlist

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.billyluisneedham.whatsinthefridge.model.FoodInstance

@Composable
fun FoodCard(modifier: Modifier = Modifier, food: FoodInstance) {
    Text(text = food.foodType.name)
}