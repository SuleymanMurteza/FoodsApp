package com.example.foodsapp.data.repo

import com.example.foodsapp.data.datasource.FoodsDataSoruce
import com.example.foodsapp.data.entity.CartFoods
import com.example.foodsapp.data.entity.Foods

class FoodsRepository(var fds:FoodsDataSoruce) {


    suspend fun getFoods(): List<Foods> = fds.getFoods()

    suspend fun addCart(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ) = fds.addCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)

    suspend fun getCartFoods( kullanici_adi: String):List<CartFoods> = fds.getCartFoods("suleyman")

    suspend fun deleteFood(sepet_yemek_id:Int,kullanici_adi: String) =fds.deleteFood(sepet_yemek_id,"suleyman")


}
