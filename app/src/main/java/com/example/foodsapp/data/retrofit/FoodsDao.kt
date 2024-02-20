package com.example.foodsapp.data.retrofit

import com.example.foodsapp.data.entity.CRUDAnswer
import com.example.foodsapp.data.entity.CartFoodsAnswer
import com.example.foodsapp.data.entity.FoodsAnswer
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/ -> Base URL
    //yemekler/tumYemekleriGetir.php -> webservice URL

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getFoods():FoodsAnswer

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addCart(@Field("yemek_adi") yemek_adi :String,
                        @Field("yemek_resim_adi") yemek_resim_adi :String,
                        @Field("yemek_fiyat") yemek_fiyat :Int,
                        @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                        @Field("kullanici_adi") kullanici_adi :String):CRUDAnswer

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getCartFoods(@Field("kullanici_adi") kullanici_adi: String):CartFoodsAnswer

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun deleteFood(@Field("sepet_yemek_id") sepet_yemek_id:Int,
                           @Field("kullanici_adi") kullanici_adi: String) : CRUDAnswer





}