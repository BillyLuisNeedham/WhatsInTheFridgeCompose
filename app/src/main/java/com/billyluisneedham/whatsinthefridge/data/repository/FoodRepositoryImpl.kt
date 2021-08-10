package com.billyluisneedham.whatsinthefridge.data.repository

import com.billyluisneedham.whatsinthefridge.domain.FoodRepository
import com.billyluisneedham.whatsinthefridge.domain.Result
import com.billyluisneedham.whatsinthefridge.domain.model.FoodInstance
import com.billyluisneedham.whatsinthefridge.mocks.FoodMocks
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor() : FoodRepository {

    override fun getAllFoods(): Flow<Result<List<FoodInstance>>> {

        val name = FoodMocks.foodInstanceMock.foodType.name
        val foodType = FoodMocks.foodInstanceMock.foodType

        val mockLargeList =
            (0..100).map {
                val newFoodType = foodType.copy(name = "$name $it")
                FoodMocks.foodInstanceMock.copy(foodType = newFoodType)
            }

        //TODO UPDATE TO GET FROM DATA SOURCE
        return flow {
            emit(Result.Success(mockLargeList))
        }
    }
}