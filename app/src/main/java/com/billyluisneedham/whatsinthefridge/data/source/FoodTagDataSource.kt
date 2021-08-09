package com.billyluisneedham.whatsinthefridge.data.source

import com.billyluisneedham.whatsinthefridge.domain.model.FoodTag
import com.billyluisneedham.whatsinthefridge.domain.model.FoodType
import com.billyluisneedham.whatsinthefridge.domain.model.TagType

interface FoodTagDataSource {

    suspend fun add(foodTag: FoodTag)
    suspend fun getAllAssociatedFoodTypesOf(tagType: TagType): List<FoodType>
    suspend fun getAllAssociatedTagTypesOf(foodType: FoodType): List<TagType>
    suspend fun delete(foodTag: FoodTag)

}