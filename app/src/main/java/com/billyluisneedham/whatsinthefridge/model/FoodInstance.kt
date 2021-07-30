package com.billyluisneedham.whatsinthefridge.model

data class FoodInstance(
    val foodInstanceId: Long = 0,
    val foodType: FoodType,
    val enteredTimeStamp: Long,
    val expiryTimeStamp: Long,
    val quantity: Int
)