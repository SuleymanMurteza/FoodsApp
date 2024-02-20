package com.example.foodsapp.data.datasource

import com.example.foodsapp.data.entity.CRUDAnswer
import com.example.foodsapp.data.entity.CartFoods
import com.example.foodsapp.data.entity.Foods
import com.example.foodsapp.data.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.Field

class FoodsDataSoruce(var fdao:FoodsDao) {

    suspend fun getFoods(): List<Foods> =
        withContext(Dispatchers.IO) {

            return@withContext fdao.getFoods().yemekler
        }

    suspend fun addCart(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String) {
        fdao.addCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
    }

    suspend fun getCartFoods(kullanici_adi: String): List<CartFoods> =
        withContext(Dispatchers.IO) {
            return@withContext fdao.getCartFoods("suleyman").sepet_yemekler
        }
    suspend fun deleteFood(sepet_yemek_id:Int,kullanici_adi: String) =fdao.deleteFood(sepet_yemek_id,"suleyman")




}