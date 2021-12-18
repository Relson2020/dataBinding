package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val observable = ObservableField<String>()

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        observable.set("Hello")
        binding.view = observable.get()

        binding.clickButton.setOnClickListener{
            val temp = binding.view
            if (temp == "Hello"){
                binding.view = "hey"
            }else{
                binding.view = "Hello"
            }
        }
    }
}