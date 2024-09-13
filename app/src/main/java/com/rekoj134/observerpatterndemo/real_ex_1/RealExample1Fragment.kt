package com.rekoj134.observerpatterndemo.real_ex_1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rekoj134.observerpatterndemo.databinding.FragmentRealExample1Binding

class RealExample1Fragment() : Fragment(), Example1Subscriber {
    private var _binding: FragmentRealExample1Binding? = null
    private val binding get() = _binding
    private var parentViewModel: ViewModel? = null

    constructor(viewModel: ViewModel) : this() {
        this.parentViewModel = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRealExample1Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        update("")
    }

    override fun update(data: String) {
        if (!isHidden) binding?.tvState?.text = data
        else {
            Handler(Looper.getMainLooper()).postDelayed({
                update(data)
            }, 100)
        }
    }
}