package com.rekoj134.observerpatterndemo.real_ex_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.rekoj134.observerpatterndemo.R
import com.rekoj134.observerpatterndemo.databinding.ActivityRealExample1Binding

class RealExample1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityRealExample1Binding
    private lateinit var viewModel: RealExample1ViewModel
    private lateinit var example1Publisher: Example1Publisher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        setupView()
        handleEvent()
    }

    private fun handleEvent() {
        binding.btnChange1.setOnClickListener {
            example1Publisher.setData("1")
        }

        binding.btnChange2.setOnClickListener {
            example1Publisher.setData("2")
        }

        binding.btnChange3.setOnClickListener {
            example1Publisher.setData("3")
        }
    }

    private fun initData() {
        viewModel = ViewModelProvider(this@RealExample1Activity)[RealExample1ViewModel::class.java]
        binding.viewModel = viewModel

        example1Publisher = Example1Publisher()
        viewModel.listFragmentPager.forEach {
            example1Publisher.subscribe(it as Example1Subscriber)
        }
    }

    private fun setupView() {
        binding.viewPager.adapter = ViewPagerAdapterEx1(this@RealExample1Activity, viewModel.listFragmentPager)
    }
}