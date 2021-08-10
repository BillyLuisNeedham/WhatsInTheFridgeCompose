package com.billyluisneedham.whatsinthefridge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.billyluisneedham.whatsinthefridge.domain.Result
import com.billyluisneedham.whatsinthefridge.domain.FoodRepository
import com.billyluisneedham.whatsinthefridge.domain.model.FoodInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val foodRepository: FoodRepository
) : ViewModel() {

    private val _foodList =
        MutableStateFlow<Result<List<FoodInstance>>>(Result.Success(emptyList()))
    val foodList: StateFlow<Result<List<FoodInstance>>> = _foodList

    init {
        viewModelScope.launch {
            foodRepository.getAllFoods()
                .collect {
                    _foodList.value = it
                }
        }
    }

}