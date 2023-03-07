package com.koonny.appcompat.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.koonny.appcompat.R

class StatusLayout : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private lateinit var contentView: View

    fun bindContentView(contentView: View) {
        this.contentView = contentView
    }

    fun isLoading(text: String) {
        removeAllViews()
        val view = LayoutInflater.from(context).inflate(R.layout.content_loading, this, false)
        view.findViewById<TextView>(R.id.tvMessage).text = text
        addView(view)
    }

    fun isSuccess() {
        removeAllViews()
        addView(contentView, rootView.layoutParams)
    }

    fun isFailure(text: String, @DrawableRes icon: Int, listener: OnClickListener) {
        removeAllViews()
        val view = LayoutInflater.from(context).inflate(R.layout.content_failure, this, false)
        view.findViewById<TextView>(R.id.tvMessage).text = text
        view.findViewById<ImageView>(R.id.iv).setImageResource(icon)
        view.findViewById<TextView>(R.id.btnRetry).setOnClickListener(listener)
        addView(view)
    }

}