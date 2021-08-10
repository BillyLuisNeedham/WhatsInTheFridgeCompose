package com.billyluisneedham.whatsinthefridge.domain

import com.billyluisneedham.whatsinthefridge.domain.model.FoodInstance
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    fun getAllFoods(): Flow<Result<List<FoodInstance>>>
}