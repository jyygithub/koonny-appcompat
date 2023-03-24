package com.koonny.sample

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.koonny.appcompat.BaseActivity
import com.koonny.appcompat.module.StatusModule
import com.koonny.sample.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), StatusModule {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            startLoading("aaaa")
            delay(2000L)
            finishLoadingWithStatus(icon = R.mipmap.ic_launcher)
        }

        MyDailog().show(supportFragmentManager)

    }

    override fun onStatusRetry(exception: Exception?) {
        lifecycleScope.launch {
            delay(2000L)
            finishLoading()
        }
    }

    override fun viewBindStatus(): View {
        return binding.button
    }

}