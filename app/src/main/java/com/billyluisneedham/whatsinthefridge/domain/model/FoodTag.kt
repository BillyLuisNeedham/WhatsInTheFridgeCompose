package com.billyluisneedham.whatsinthefridge.domain.model

data class FoodTag(
    val foodTagId: Long = 0,
    val tagTypeId: Long,
    val foodTypeId: Long
)
