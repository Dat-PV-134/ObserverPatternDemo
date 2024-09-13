package com.rekoj134.observerpatterndemo.implement_ex

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rekoj134.observerpatterndemo.R
import com.rekoj134.observerpatterndemo.constant.NORMAL
import com.rekoj134.observerpatterndemo.constant.PREMIUM
import com.rekoj134.observerpatterndemo.databinding.ActivityYoutubeBinding

class YoutubeActivity : AppCompatActivity(), Subscriber {
    private lateinit var binding: ActivityYoutubeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYoutubeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val youtubeChannel = YoutubeChannel()
        val normalUser1 = NormalUser()
        val normalUser2 = NormalUser()
        val premiumUser = PremiumUser()
        youtubeChannel.subscribe(NORMAL, normalUser1)
        youtubeChannel.subscribe(NORMAL, normalUser2)
        youtubeChannel.subscribe(PREMIUM, premiumUser)
        youtubeChannel.subscribe(PREMIUM, this@YoutubeActivity)

        val youtube = Youtube(youtubeChannel)

        binding.btnNotifyNormal.setOnClickListener {
            binding.tvData.text = "Notified normal people"
            youtube.notifyNormalUser("Ăn cứt ko bạn hiền")
        }

        binding.btnNotifyPremium.setOnClickListener {
            youtube.notifyPremiumUser("Hello ae hehehehe")
        }
    }

    override fun notifyNew(data: String) {
        binding.tvData.text = data
    }
}