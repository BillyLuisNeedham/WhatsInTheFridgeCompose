package com.billyluisneedham.whatsinthefridge.model

data class FoodTag(
    val foodTagId: Long = 0,
    val tagTypeId: Long,
    val foodTypeId: Long
)
