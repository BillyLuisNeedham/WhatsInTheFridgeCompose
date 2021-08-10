package com.billyluisneedham.whatsinthefridge.data.source

import com.billyluisneedham.whatsinthefridge.domain.model.FoodInstance
import kotlinx.coroutines.flow.Flow

interface FoodInstanceDataSource {

    suspend fun add(foodInstance: FoodInstance)
    fun getAll(foodInstance: FoodInstance): Flow<List<FoodInstance>>
    suspend fun delete(foodInstance: FoodInstance)
    suspend fun update(foodInstance: FoodInstance)

}