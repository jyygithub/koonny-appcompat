package com.koonny.appcompat

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.koonny.appcompat.core.setGradientRes
import com.koonny.appcompat.module.PrepareModule

abstract class BaseDialogFragment<VB : ViewBinding>(private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB) : DialogFragment(),
    PrepareModule {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    protected open val gravity: Int = Gravity.BOTTOM
    protected open val width: Int = 100
    protected open val height: Int = 0
    protected open val dismissOnTouchOutside: Boolean = true
    protected open val dismissOnBackPressed: Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root.apply {
            if (gravity == Gravity.BOTTOM) {
                this.setGradientRes(R.color.colorBackground, R.dimen.dp_20, R.dimen.dp_20, 0, 0)
            } else {
                this.setGradientRes(R.color.colorBackground, R.dimen.dp_20)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val w = if (this.width <= 0) ViewGroup.LayoutParams.WRAP_CONTENT else resources.displayMetrics.widthPixels * this.width / 100
        val h = if (this.height <= 0) ViewGroup.LayoutParams.WRAP_CONTENT else resources.displayMetrics.heightPixels * this.height / 100
        dialog?.setCanceledOnTouchOutside(dismissOnTouchOutside)
        dialog?.setCancelable(dismissOnBackPressed)
        dialog?.window?.apply {
            setGravity(gravity)
            setLayout(w, h)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun show(manager: FragmentManager) {
        super.show(manager, javaClass.simpleName)
    }

}