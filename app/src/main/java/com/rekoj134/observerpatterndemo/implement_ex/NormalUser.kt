package com.rekoj134.observerpatterndemo.implement_ex

import android.util.Log

class NormalUser : Subscriber {
    override fun notifyNew(data: String) {
        Log.e("ANCUTKO", "This is for normal user: $data")
    }
}