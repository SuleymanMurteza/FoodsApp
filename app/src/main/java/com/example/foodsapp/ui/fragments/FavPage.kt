package com.example.foodsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodsapp.R
import com.example.foodsapp.data.entity.FavFoods
import com.example.foodsapp.databinding.FragmentFavPageBinding
import com.example.foodsapp.ui.adapter.FavAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class FavPage : Fragment() {
    private lateinit var binding:FragmentFavPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentFavPageBinding.inflate(LayoutInflater.from(context),container,false)
        binding.rvFavFood.layoutManager=LinearLayoutManager(requireContext())

        val favFoods=ArrayList<FavFoods>()
        val f1=FavFoods(0,"Baklava","abc",70)
        val f2=FavFoods(0,"Baklava","abc",70)
        val f3=FavFoods(0,"Baklava","abc",70)
        favFoods.add(f1)
        favFoods.add(f2)
        favFoods.add(f3)

        val favFoodsAdapter=FavAdapter(requireContext(),favFoods)
        binding.rvFavFood.adapter=favFoodsAdapter



        return binding.root
    }


}