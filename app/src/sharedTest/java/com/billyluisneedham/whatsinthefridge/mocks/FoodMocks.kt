package com.billyluisneedham.whatsinthefridge.mocks

import com.billyluisneedham.whatsinthefridge.model.FoodInstance
import com.billyluisneedham.whatsinthefridge.model.FoodType
import com.billyluisneedham.whatsinthefridge.util.daysToMilliseconds

object FoodMocks {

    private val fiveDaysInMilliseconds = 5L.daysToMilliseconds()

    private val now = System.currentTimeMillis()

    private val foodTypeMock = FoodType(
        foodTypeId = 12,
        name = "test food type",
        instances = 50,
        averageShelfLife = fiveDaysInMilliseconds,
    )

    val foodInstanceMock = FoodInstance(
        foodInstanceId = 1,
        foodType = foodTypeMock,
        enteredTimeStamp = now,
        expiryTimeStamp = now + fiveDaysInMilliseconds,
        quantity = 5
        )
}