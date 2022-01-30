package com.example.myapplication.root.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication.R
import com.example.myapplication.root.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel :MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setData()
    }


    fun setData(){
        viewModel.dataStateLiveData.observe(this,{ dataState->
             when(dataState){
                 is DataState.Error -> {showErrorView()}
                 is DataState.Loading -> {showLoadingView()}
                 is DataState.Success -> {}
             }
        })
    }


    fun showErrorView(){}

    fun showLoadingView(){}
}