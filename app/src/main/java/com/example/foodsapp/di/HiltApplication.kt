package com.example.foodsapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication:Application() {//manifestte name yazarak uygulamaya tanıtmamız lazım.
}