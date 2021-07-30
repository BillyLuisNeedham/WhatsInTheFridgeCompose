package com.billyluisneedham.whatsinthefridge.source

import com.billyluisneedham.whatsinthefridge.model.FoodType
import com.billyluisneedham.whatsinthefridge.model.TagType

interface FoodTypeDataSource {

    suspend fun add(foodType: FoodType)
    suspend fun getAll(): List<FoodType>
    suspend fun update(foodType: FoodType)
    suspend fun delete(foodType: FoodType)
    suspend fun addTag(tagType: TagType)
    suspend fun removeTag(tagType: TagType)
    suspend fun updateAverageShelfLife(latestShelfLife: Long)

}