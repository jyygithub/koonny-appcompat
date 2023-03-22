package com.koonny.appcompat.core

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.Px
import androidx.core.view.ViewCompat

fun View.setGradient(@ColorInt color: Int, @Px radius: Int) {
    val drawable = GradientDrawable()
    drawable.color = ColorStateList.valueOf(color)
    drawable.cornerRadius = radius + 0f
    ViewCompat.setBackground(this, drawable)
}

fun View.setGradient(@ColorInt color: Int, @Px topLeftRadius: Int, @Px topRightRadius: Int, @Px bottomLeftRadius: Int, @Px bottomRightRadius: Int) {
    val cornerRadii = floatArrayOf(
        topLeftRadius + 0f, topLeftRadius + 0f, topRightRadius + 0f, topRightRadius + 0f,
        bottomRightRadius + 0f, bottomRightRadius + 0f, bottomLeftRadius + 0f, bottomLeftRadius + 0f,
    )
    val drawable = GradientDrawable()
    drawable.color = ColorStateList.valueOf(color)
    drawable.cornerRadii = cornerRadii
    ViewCompat.setBackground(this, drawable)
}

fun View.setRipple(@ColorInt color: Int, @Px radius: Int) {
    val contentDrawable = GradientDrawable()
    contentDrawable.color = ColorStateList.valueOf(color)
    contentDrawable.cornerRadius = radius + 0f
    val maskDrawable = GradientDrawable()
    maskDrawable.color = ColorStateList.valueOf(Color.RED)
    maskDrawable.cornerRadius = radius + 0f
    val rippleDrawable = RippleDrawable(ColorStateList.valueOf(Color.parseColor("#cccccc")), contentDrawable, maskDrawable)
    ViewCompat.setBackground(this, rippleDrawable)
}

fun View.setRipple(@ColorInt color: Int, @Px topLeftRadius: Int, @Px topRightRadius: Int, @Px bottomLeftRadius: Int, @Px bottomRightRadius: Int) {
    val cornerRadii = floatArrayOf(
        topLeftRadius + 0f, topLeftRadius + 0f, topRightRadius + 0f, topRightRadius + 0f,
        bottomRightRadius + 0f, bottomRightRadius + 0f, bottomLeftRadius + 0f, bottomLeftRadius + 0f,
    )
    val contentDrawable = GradientDrawable()
    contentDrawable.color = ColorStateList.valueOf(color)
    contentDrawable.cornerRadii = cornerRadii
    val maskDrawable = GradientDrawable()
    maskDrawable.color = ColorStateList.valueOf(Color.RED)
    maskDrawable.cornerRadii = cornerRadii
    val rippleDrawable = RippleDrawable(ColorStateList.valueOf(Color.parseColor("#cccccc")), contentDrawable, maskDrawable)
    ViewCompat.setBackground(this, rippleDrawable)
}