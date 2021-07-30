package com.billyluisneedham.whatsinthefridge.source

import com.billyluisneedham.whatsinthefridge.model.FoodInstance

interface FoodInstanceDataSource {

    suspend fun add(foodInstance: FoodInstance)
    suspend fun getAll(foodInstance: FoodInstance): List<FoodInstance>
    suspend fun delete(foodInstance: FoodInstance)
    suspend fun update(foodInstance: FoodInstance)

}