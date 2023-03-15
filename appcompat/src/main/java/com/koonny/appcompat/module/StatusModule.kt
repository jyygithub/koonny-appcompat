package com.koonny.appcompat.module

import android.view.View

interface StatusModule {
    fun viewBindStatus(): View
    fun onStatusRetry(exception: Exception)
}