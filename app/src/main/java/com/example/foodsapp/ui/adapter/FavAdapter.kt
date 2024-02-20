package com.example.foodsapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodsapp.data.entity.FavFoods
import com.example.foodsapp.databinding.CardDesignthreeBinding

class FavAdapter(var mContext:Context, var favFoodList:List<FavFoods>)
    :RecyclerView.Adapter<FavAdapter.CardHolder>() {



    inner class CardHolder(var binding:CardDesignthreeBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding=CardDesignthreeBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardHolder(binding)
    }

    override fun getItemCount(): Int {
        return favFoodList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val favFood=favFoodList.get(position)
        val t=holder.binding

        t.textViewFavPrice.text="Fiyat: ₺ ${favFood.yemek_fiyat}"
        t.textViewFoodNamee.text=favFood.yemek_adi
    }
}