package com.koonny.appcompat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.view.indices
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.koonny.appcompat.module.PrepareModule
import com.koonny.appcompat.module.StatusModule
import com.koonny.appcompat.widget.StatusLayout

abstract class BaseFragment<VB : ViewBinding>(private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB) : Fragment(), PrepareModule {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    private lateinit var statusLayout: StatusLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflate.invoke(inflater, container, false)
        return if (this is StatusModule) {
            if (viewBindStatus() == binding.root) {
                insertStatusWithRoot()
            } else {
                insertStatusWithChild(viewBindStatus())
            }
        } else {
            binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onPrepareData()
        onPrepareValue()
        onPrepareWidget()
    }

    override fun onPrepareValue() {
    }

    override fun onPrepareWidget() {
    }

    override fun onPrepareData() {
    }

    private fun insertStatusWithRoot(): View {
        statusLayout = StatusLayout(binding.root.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            bindContentView(binding.root)
        }
        return statusLayout
    }

    private fun insertStatusWithChild(childView: View): View {
        val childViewParent = childView.parent as ViewGroup
        var viewIndex = -1
        for (index in childViewParent.indices) {
            if (childView === childViewParent.getChildAt(index)) {
                viewIndex = index
                break
            }
        }
        childViewParent.removeViewAt(viewIndex)
        statusLayout = StatusLayout(binding.root.context).apply {
            layoutParams = childView.layoutParams
            bindContentView(childView)
        }
        childViewParent.addView(statusLayout, viewIndex)
        return binding.root
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}