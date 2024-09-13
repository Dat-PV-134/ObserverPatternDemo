package com.rekoj134.observerpatterndemo.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rekoj134.observerpatterndemo.R
import com.rekoj134.observerpatterndemo.constant.NORMAL
import com.rekoj134.observerpatterndemo.constant.PREMIUM
import com.rekoj134.observerpatterndemo.databinding.ActivityMainBinding
import com.rekoj134.observerpatterndemo.implement_ex.NormalUser
import com.rekoj134.observerpatterndemo.implement_ex.PremiumUser
import com.rekoj134.observerpatterndemo.implement_ex.Youtube
import com.rekoj134.observerpatterndemo.implement_ex.YoutubeActivity
import com.rekoj134.observerpatterndemo.implement_ex.YoutubeChannel
import com.rekoj134.observerpatterndemo.real_ex_1.RealExample1Activity
import com.rekoj134.observerpatterndemo.real_ex_1.RealExample1ViewModel
import com.rekoj134.observerpatterndemo.real_ex_2.RealExample2Activity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnImplement.setOnClickListener {
            startActivity(Intent(this@MainActivity, YoutubeActivity::class.java))
        }

        binding.btnRealEx1.setOnClickListener {
            startActivity(Intent(this@MainActivity, RealExample1Activity::class.java))
        }

        binding.btnRealEx2.setOnClickListener {
            startActivity(Intent(this@MainActivity, RealExample2Activity::class.java))
        }
    }
}