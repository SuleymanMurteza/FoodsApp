package com.example.foodsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.foodsapp.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodsDetailViewModel @Inject constructor(var frs: FoodsRepository):ViewModel() {

    fun addCart(yemek_adi: String,
                yemek_resim_adi: String,
                yemek_fiyat: Int,
                yemek_siparis_adet: Int,
                kullanici_adi: String){
        CoroutineScope((Dispatchers.Main)).launch {
            frs.addCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
        }
    }
}