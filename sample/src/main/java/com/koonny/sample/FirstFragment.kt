package com.koonny.sample

import android.os.Bundle
import android.view.View
import com.koonny.appcompat.BaseFragment
import com.koonny.sample.databinding.ActivityMainBinding

class FirstFragment : BaseFragment<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO
    }

}