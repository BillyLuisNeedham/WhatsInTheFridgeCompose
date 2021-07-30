package com.billyluisneedham.whatsinthefridge.model

data class FoodType(
    val foodTypeId: Long = 0,
    val name: String,
    val instances: Long,
    val averageShelfLife: Long,
    val tags: List<TagType>? = null
)