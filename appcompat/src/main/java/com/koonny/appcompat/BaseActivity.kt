package com.koonny.appcompat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.indices
import androidx.viewbinding.ViewBinding
import com.koonny.appcompat.module.PrepareModule
import com.koonny.appcompat.module.StatusModule
import com.koonny.appcompat.widget.StatusLayout

abstract class BaseActivity<VB : ViewBinding>(private val inflate: (LayoutInflater) -> VB) : AppCompatActivity(), PrepareModule {

    protected lateinit var binding: VB
    private lateinit var statusLayout: StatusLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate.invoke(layoutInflater)
        if (this is StatusModule) {
            if (viewBindStatus() == binding.root) {
                insertStatusWithRoot()
            } else {
                insertStatusWithChild(viewBindStatus())
            }
        } else {
            setContentView(binding.root)
        }
        onPrepareValue()
        onPrepareWidget()
        onPrepareData()
    }

    override fun onPrepareValue() {
    }

    override fun onPrepareWidget() {
    }

    override fun onPrepareData() {
    }

    private fun insertStatusWithRoot() {
        statusLayout = StatusLayout(binding.root.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            bindContentView(binding.root)
        }
        setContentView(statusLayout)
    }

    private fun insertStatusWithChild(childView: View) {
        val childViewParent = childView.parent as ViewGroup
        var viewIndex = -1
        for (index in childViewParent.indices) {
            if (childView === childViewParent.getChildAt(index)) {
                viewIndex = index
                break
            }
        }
        childViewParent.removeViewAt(viewIndex)
        statusLayout = StatusLayout(this).apply {
            layoutParams = childView.layoutParams
            bindContentView(childView)
        }
        childViewParent.addView(statusLayout, viewIndex)
        setContentView(binding.root)
    }

    fun startLoading(text: String = "正在加载...") {
        if (this is StatusModule) {
            statusLayout.isLoading(text)
        }
    }

    fun finishLoadingWithStatus(text: String = "数据加载失败", @DrawableRes icon: Int) {
        if (this is StatusModule) {
            statusLayout.isFailure(text, icon) {
                onStatusRetry(Exception(text))
                startLoading()
            }
        }
    }

    fun finishLoadingWithStatus(exception: Exception, @DrawableRes icon: Int) {
        if (this is StatusModule) {
            statusLayout.isFailure(exception.message.orEmpty(), icon) {
                onStatusRetry(exception)
                startLoading()
            }
        }
    }

    fun finishLoading() {
        if (this is StatusModule) {
            statusLayout.isSuccess()
        }
    }

}