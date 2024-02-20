package com.example.foodsapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodsapp.data.entity.CartFoods
import com.example.foodsapp.databinding.CardDesigntwoBinding
import com.example.foodsapp.ui.viewmodels.CartViewModel

class CartAdapter(var mContext:Context,var cartFoodList:List<CartFoods>,var viewModel:CartViewModel)
    :RecyclerView.Adapter<CartAdapter.CardHolder>() {


    inner class CardHolder(var binding:CardDesigntwoBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding=CardDesigntwoBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartFoodList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val food=cartFoodList.get(position)
        val t=holder.binding


        t.textViewCount.text="Adet : ${food.yemek_siparis_adet}"
        t.textViewFoodNamee.text=food.yemek_adi
        t.textViewPrice.text="Fiyat : ₺${food.yemek_fiyat}"
        t.textViewTotall.text="₺ ${food.yemek_fiyat*food.yemek_siparis_adet}"
        val url="http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(400,400).into(t.imageViewFoodCard)//resimleri gösterdik.

        t.imageViewDelete.setOnClickListener {
            viewModel.deleteFood(food.sepet_yemek_id,"suleyman")

        }


    }
    @SuppressLint("NotifyDataSetChanged")
    fun setCarts(carts: MutableLiveData<List<CartFoods>>) {
        this.cartFoodList= cartFoodList
        notifyDataSetChanged()
    }


}