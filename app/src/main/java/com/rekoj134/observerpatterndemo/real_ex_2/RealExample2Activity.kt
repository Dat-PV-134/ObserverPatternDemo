package com.rekoj134.observerpatterndemo.real_ex_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.rekoj134.observerpatterndemo.databinding.ActivityRealExample2Binding
import com.tools.flashalert.observer.NetworkConnectivityObserver
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RealExample2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityRealExample2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealExample2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        val connectivityObserver = NetworkConnectivityObserver(applicationContext)
        var defaultInternetState: ConnectivityObserver.Status

        connectivityObserver.observe().onEach {
            defaultInternetState = it
            if (defaultInternetState != ConnectivityObserver.Status.Available) {
                binding.tvState.text = "Disconnected"
            } else {
                binding.tvState.text = "Connected"
            }
        }.launchIn(lifecycleScope)
    }
}