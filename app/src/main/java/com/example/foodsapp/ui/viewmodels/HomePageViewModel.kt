package com.example.foodsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodsapp.data.entity.Foods
import com.example.foodsapp.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(var frs:FoodsRepository):ViewModel() {

    var foodsList = MutableLiveData<List<Foods>>()

    init {
        getFoods()
    }

    fun getFoods(){
        CoroutineScope(Dispatchers.Main).launch{
            foodsList.value=frs.getFoods()
        }
    }


}