package com.example.foodsapp.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodsapp.data.entity.CartFoods
import com.example.foodsapp.databinding.FragmentCartPageBinding
import com.example.foodsapp.ui.adapter.CartAdapter
import com.example.foodsapp.ui.viewmodels.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CartPage : Fragment() {
    private lateinit var binding: FragmentCartPageBinding
    private lateinit var viewModel : CartViewModel
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentCartPageBinding.inflate(LayoutInflater.from(context),container,false)
        binding.cartRecycler.layoutManager=LinearLayoutManager(requireContext())


        viewModel.cartFoodsList.observe(viewLifecycleOwner){
            val cart=it

            val cartAdapter=CartAdapter(requireContext(),it,viewModel)
            binding.cartRecycler.adapter=cartAdapter
            cartAdapter.setCarts(viewModel.cartFoodsList)
            cartAdapter.notifyDataSetChanged()

        }


        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {//anasayfaya döndüğümüzde yemekleri tekrar yükleyecek.
        super.onResume()
        viewModel.getCartFoods()
    }


}
