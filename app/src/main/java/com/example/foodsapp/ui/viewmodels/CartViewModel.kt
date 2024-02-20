package com.example.foodsapp.ui.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodsapp.data.entity.CartFoods
import com.example.foodsapp.data.entity.Foods
import com.example.foodsapp.data.repo.FoodsRepository
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(var frs: FoodsRepository):ViewModel() {

    var cartFoodsList = MutableLiveData<List<CartFoods>>()

    init {
        getCartFoods()
    }


    fun getCartFoods() {
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    cartFoodsList.value = frs.getCartFoods("suleyman")

                }catch (_:Exception){

                }
            }
    }


    fun deleteFood(sepet_yemek_id: Int, kullanici_adi: String) {
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    frs.deleteFood(sepet_yemek_id, "suleyman")
                    getCartFoods()//silme işleminden sonra sepetin yeni hali için.
                }catch (_:Exception){

                }

            }



    }
}

