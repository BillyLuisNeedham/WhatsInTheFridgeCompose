package com.billyluisneedham.whatsinthefridge.data.source

import com.billyluisneedham.whatsinthefridge.domain.model.FoodInstance

interface FoodInstanceDataSource {

    suspend fun add(foodInstance: FoodInstance)
    suspend fun getAll(foodInstance: FoodInstance): List<FoodInstance>
    suspend fun delete(foodInstance: FoodInstance)
    suspend fun update(foodInstance: FoodInstance)

}