package com.example.foodsapp.data.entity

data class FoodsAnswer(var yemekler:List<Foods>,
                       var success:Int) { // Bu class bize veritabanı üzerinden cevap olarak liste getirecek.
}