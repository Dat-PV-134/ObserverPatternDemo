package com.rekoj134.observerpatterndemo.implement_ex

import com.rekoj134.observerpatterndemo.constant.NORMAL
import com.rekoj134.observerpatterndemo.constant.PREMIUM

class Youtube(youtubeChannel: YoutubeChannel) {
    private val youtubeChannels by lazy { ArrayList<YoutubeChannel>() }

    init {
        this.youtubeChannels.add(youtubeChannel)
    }

    fun notifyPremiumUser(data: String) {
        youtubeChannels.forEach {
            it.notifySubscribers(PREMIUM, data)
        }
    }

    fun notifyNormalUser(data: String) {
        youtubeChannels.forEach {
            it.notifySubscribers(NORMAL, data)
        }
    }
}