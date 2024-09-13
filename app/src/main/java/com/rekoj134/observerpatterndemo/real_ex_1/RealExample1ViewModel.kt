package com.rekoj134.observerpatterndemo.real_ex_1

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RealExample1ViewModel : ViewModel() {
    var listFragmentPager = arrayListOf<Fragment>(
        RealExample1Fragment(
            this@RealExample1ViewModel
        ),
        RealExample1Fragment(
            this@RealExample1ViewModel
        ),
        RealExample1Fragment(
            this@RealExample1ViewModel
        ),
        RealExample1Fragment(
            this@RealExample1ViewModel
        ),
        RealExample1Fragment(
            this@RealExample1ViewModel
        )
    )
}