package com.billyluisneedham.whatsinthefridge.source

import com.billyluisneedham.whatsinthefridge.model.FoodTag
import com.billyluisneedham.whatsinthefridge.model.FoodType
import com.billyluisneedham.whatsinthefridge.model.TagType

interface FoodTagDataSource {

    suspend fun add(foodTag: FoodTag)
    suspend fun getAllAssociatedFoodTypesOf(tagType: TagType): List<FoodType>
    suspend fun getAllAssociatedTagTypesOf(foodType: FoodType): List<TagType>
    suspend fun delete(foodTag: FoodTag)

}