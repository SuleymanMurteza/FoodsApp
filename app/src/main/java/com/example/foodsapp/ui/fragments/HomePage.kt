package com.example.foodsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodsapp.R
import com.example.foodsapp.data.datasource.FoodsDataSoruce
import com.example.foodsapp.data.entity.Foods
import com.example.foodsapp.data.repo.FoodsRepository
import com.example.foodsapp.data.retrofit.FoodsDao
import com.example.foodsapp.databinding.FragmentHomePageBinding
import com.example.foodsapp.ui.adapter.FoodsAdapter
import com.example.foodsapp.ui.viewmodels.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomePage : Fragment() {
    private lateinit var binding:FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentHomePageBinding.inflate(inflater,container,false)




        binding.recyclerViewHome.layoutManager=GridLayoutManager(requireContext(),2)

        viewModel.foodsList.observe(viewLifecycleOwner){
            val foodsAdapter=FoodsAdapter(requireContext(),it,viewModel)
            binding.recyclerViewHome.adapter=foodsAdapter
        }



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel=tempViewModel

    }

}