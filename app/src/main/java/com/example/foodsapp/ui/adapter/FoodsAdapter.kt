package com.example.foodsapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.R
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodsapp.data.entity.CartFoods
import com.example.foodsapp.data.entity.Foods
import com.example.foodsapp.databinding.CardDesignBinding
import com.example.foodsapp.ui.fragments.HomePageDirections
import com.example.foodsapp.ui.viewmodels.HomePageViewModel

class FoodsAdapter(var mContext:Context,var foodList:List<Foods>,var viewModel: HomePageViewModel)
    :RecyclerView.Adapter<FoodsAdapter.CardDesignHolder>() {



    inner class CardDesignHolder(var binding:CardDesignBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding=CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food=foodList.get(position)
        val t = holder.binding
        t.foodPriceTextView.text="₺ ${food.yemek_fiyat}"
        t.foodNameTextView.text=food.yemek_adi
        val url="http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(400,400).into(t.imageViewFood)//resimleri gösterdik.

        t.FoodsCardView.setOnClickListener {
            val goTo=HomePageDirections.actionHomePageToFoodsDetail(food)
            Navigation.findNavController(it).navigate(goTo)
        }

        t.quantityImage.setOnClickListener {
            val goTo=HomePageDirections.actionHomePageToFoodsDetail(food)
            Navigation.findNavController(it).navigate(goTo)

        }


    }


}