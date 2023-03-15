package com.koonny.appcompat.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.annotation.DrawableRes

class StatusLayout : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private lateinit var mContentView: View

    private val mPrimaryTypeValue by lazy {
        TypedValue().apply {
            context.theme.resolveAttribute(android.R.attr.colorPrimary, this, true)
        }
    }
    private val mNonContentView: LinearLayout by lazy {
        LinearLayout(context).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(16, 16, 16, 16)
        }
    }
    private val mNonMessageView: TextView by lazy {
        TextView(context).apply {
            gravity = Gravity.CENTER
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
                setMargins(20, 10, 20, 10)
            }
        }
    }
    private val mNonLoadingView: ProgressBar by lazy {
        ProgressBar(context, null, android.R.attr.progressBarStyleLarge).apply {
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        }
    }
    private val mNonImageView: ImageView by lazy {
        ImageView(context).apply {
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        }
    }
    private val mNonRetryView: TextView by lazy {
        TextView(context).apply {
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
                setMargins(10, 50, 10, 10)
            }
            background = GradientDrawable().apply {
                setStroke(2, mPrimaryTypeValue.data)
                color = ColorStateList.valueOf(Color.TRANSPARENT)
                cornerRadius = 20f
            }
            setTextColor(mPrimaryTypeValue.data)
            setPadding(30, 8, 30, 8)
        }
    }

    fun bindContentView(contentView: View) {
        this.mContentView = contentView
    }

    fun isLoading(text: String) {
        removeAllViews()
        mNonMessageView.text = text
        mNonContentView.apply {
            removeAllViews()
            addView(mNonLoadingView)
            addView(mNonMessageView)
        }
        addView(mNonContentView)
    }

    fun isSuccess() {
        removeAllViews()
        addView(mContentView, rootView.layoutParams)
    }

    fun isFailure(text: String, @DrawableRes icon: Int, listener: OnClickListener) {
        removeAllViews()

        mNonImageView.setImageResource(icon)
        mNonMessageView.text = text
        mNonRetryView.apply {
            setText("重新加载")
            setOnClickListener(listener)
        }
        mNonContentView.apply {
            removeAllViews()
            addView(mNonImageView)
            addView(mNonMessageView)
            addView(mNonRetryView)
        }
        addView(mNonContentView)
    }

}