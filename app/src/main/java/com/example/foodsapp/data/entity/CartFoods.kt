package com.example.foodsapp.data.entity

data class CartFoods(var sepet_yemek_id :Int,
                     var yemek_adi: String,
                     var yemek_resim_adi :String,
                     var yemek_fiyat :Int,
                     var yemek_siparis_adet :Int,
                     var kullanici_adi :String) {
}