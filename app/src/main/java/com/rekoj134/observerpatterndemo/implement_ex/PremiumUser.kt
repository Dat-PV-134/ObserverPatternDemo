package com.rekoj134.observerpatterndemo.implement_ex

import android.util.Log

class PremiumUser : Subscriber {
    override fun notifyNew(data: String) {
        Log.e("ANCUTKO", "This is for premium user: $data")
    }
}