package com.example.foodsapp.ui.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.ColorInt
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodsapp.R
import com.example.foodsapp.data.datasource.FoodsDataSoruce
import com.example.foodsapp.data.entity.CartFoods
import com.example.foodsapp.data.entity.CartFoodsTypr
import com.example.foodsapp.data.repo.FoodsRepository
import com.example.foodsapp.data.retrofit.FoodsDao
import com.example.foodsapp.databinding.FragmentFoodsDetailBinding
import com.example.foodsapp.ui.viewmodels.CartViewModel
import com.example.foodsapp.ui.viewmodels.FoodsDetailViewModel
import com.example.foodsapp.ui.viewmodels.HomePageViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class FoodsDetail : Fragment() {
    private lateinit var binding: FragmentFoodsDetailBinding
    private lateinit var viewModel: FoodsDetailViewModel
    private lateinit var viewModel2: CartViewModel

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodsDetailBinding.inflate(LayoutInflater.from(context), container, false)

        val bundle: FoodsDetailArgs by navArgs()
        val food = bundle.foodslist

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(this).load(url).override(400, 400).into(binding.imageView4)//resimleri gösterdik.


        binding.textViewFoodName.text = food.yemek_adi
        binding.textViewPriceDetay.text = "₺ ${food.yemek_fiyat}"
        binding.textViewTotal.text = "₺ ${food.yemek_fiyat}"
        var foodQuantity = 1
        binding.buttonAdd.setOnClickListener {
            foodQuantity++
            binding.textViewAdet.text = foodQuantity.toString()
            var total = foodQuantity * food.yemek_fiyat
            binding.textViewTotal.text = "₺ $total"
        }
        binding.buttonRemove.setOnClickListener {
            if (foodQuantity > 1) {
                foodQuantity--
                binding.textViewAdet.text = foodQuantity.toString()
                var total = foodQuantity * food.yemek_fiyat
                binding.textViewTotal.text = "₺ $total"
            } else {
                foodQuantity = 1
            }
        }

        val foodList= mutableListOf<CartFoods>()


        binding.buttonAddToCart.setOnClickListener {

                    viewModel.addCart(
                        food.yemek_adi,
                        food.yemek_resim_adi,
                        food.yemek_fiyat,
                        foodQuantity,
                        "suleyman"
                    )
                }

            return binding.root
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val tempViewModel: FoodsDetailViewModel by viewModels()
            viewModel = tempViewModel
        }


}
