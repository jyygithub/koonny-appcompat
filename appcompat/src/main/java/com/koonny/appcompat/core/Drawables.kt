package com.koonny.appcompat.core

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Px
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

fun View.setGradient(@ColorInt color: Int, @Px radius: Int) {
    val drawable = GradientDrawable()
    drawable.color = ColorStateList.valueOf(color)
    drawable.cornerRadius = radius + 0f
    ViewCompat.setBackground(this, drawable)
}

fun View.setGradientRes(@ColorRes color: Int, @DimenRes radius: Int) {
    val drawable = GradientDrawable()
    drawable.color = ContextCompat.getColorStateList(context, color)
    drawable.cornerRadius = if (radius == 0) 0f else resources.getDimension(radius)
    ViewCompat.setBackground(this, drawable)
}

fun View.setGradient(@ColorInt color: Int, @Px topLeftRadius: Int, @Px topRightRadius: Int, @Px bottomLeftRadius: Int, @Px bottomRightRadius: Int) {
    val array = floatArrayOf(
        topLeftRadius + 0f, topLeftRadius + 0f, topRightRadius + 0f, topRightRadius + 0f,
        bottomRightRadius + 0f, bottomRightRadius + 0f, bottomLeftRadius + 0f, bottomLeftRadius + 0f,
    )
    val drawable = GradientDrawable()
    drawable.color = ColorStateList.valueOf(color)
    drawable.cornerRadii = array
    ViewCompat.setBackground(this, drawable)
}

fun View.setGradientRes(
    @ColorRes color: Int,
    @DimenRes topLeftRadius: Int,
    @DimenRes topRightRadius: Int,
    @DimenRes bottomLeftRadius: Int,
    @DimenRes bottomRightRadius: Int
) {
    val array = floatArrayOf(
        if (topLeftRadius == 0) 0f else resources.getDimension(topLeftRadius),
        if (topLeftRadius == 0) 0f else resources.getDimension(topLeftRadius),
        if (topRightRadius == 0) 0f else resources.getDimension(topRightRadius),
        if (topRightRadius == 0) 0f else resources.getDimension(topRightRadius),
        if (bottomLeftRadius == 0) 0f else resources.getDimension(bottomLeftRadius),
        if (bottomLeftRadius == 0) 0f else resources.getDimension(bottomLeftRadius),
        if (bottomRightRadius == 0) 0f else resources.getDimension(bottomRightRadius),
        if (bottomRightRadius == 0) 0f else resources.getDimension(bottomRightRadius),
    )
    val drawable = GradientDrawable()
    drawable.color = ContextCompat.getColorStateList(context, color)
    drawable.cornerRadii = array
    ViewCompat.setBackground(this, drawable)
}

fun View.setRipple(@ColorInt color: Int, @Px radius: Int) {
    val contentDrawable = GradientDrawable()
    contentDrawable.color = ColorStateList.valueOf(color)
    contentDrawable.cornerRadius = radius + 0f
    val maskDrawable = GradientDrawable()
    maskDrawable.color = ColorStateList.valueOf(Color.BLACK)
    maskDrawable.cornerRadius = radius + 0f
    val rippleDrawable = RippleDrawable(ColorStateList.valueOf(Color.parseColor("#cccccc")), contentDrawable, maskDrawable)
    ViewCompat.setBackground(this, rippleDrawable)
}

fun View.setRippleRes(@ColorRes color: Int, @DimenRes radius: Int) {
    val contentDrawable = GradientDrawable()
    contentDrawable.color = ContextCompat.getColorStateList(context, color)
    contentDrawable.cornerRadius = if (radius == 0) 0f else resources.getDimension(radius)
    val maskDrawable = GradientDrawable()
    maskDrawable.color = ColorStateList.valueOf(Color.BLACK)
    maskDrawable.cornerRadius = if (radius == 0) 0f else resources.getDimension(radius)
    val rippleDrawable = RippleDrawable(ColorStateList.valueOf(Color.parseColor("#cccccc")), contentDrawable, maskDrawable)
    ViewCompat.setBackground(this, rippleDrawable)
}

fun View.setRipple(@ColorInt color: Int, @Px topLeftRadius: Int, @Px topRightRadius: Int, @Px bottomLeftRadius: Int, @Px bottomRightRadius: Int) {
    val array = floatArrayOf(
        topLeftRadius + 0f, topLeftRadius + 0f, topRightRadius + 0f, topRightRadius + 0f,
        bottomRightRadius + 0f, bottomRightRadius + 0f, bottomLeftRadius + 0f, bottomLeftRadius + 0f,
    )
    val contentDrawable = GradientDrawable()
    contentDrawable.color = ColorStateList.valueOf(color)
    contentDrawable.cornerRadii = array
    val maskDrawable = GradientDrawable()
    maskDrawable.color = ColorStateList.valueOf(Color.RED)
    maskDrawable.cornerRadii = array
    val rippleDrawable = RippleDrawable(ColorStateList.valueOf(Color.parseColor("#cccccc")), contentDrawable, maskDrawable)
    ViewCompat.setBackground(this, rippleDrawable)
}

fun View.setRippleRes(
    @ColorRes color: Int,
    @DimenRes topLeftRadius: Int,
    @DimenRes topRightRadius: Int,
    @DimenRes bottomLeftRadius: Int,
    @DimenRes bottomRightRadius: Int
) {
    val array = floatArrayOf(
        if (topLeftRadius == 0) 0f else resources.getDimension(topLeftRadius),
        if (topLeftRadius == 0) 0f else resources.getDimension(topLeftRadius),
        if (topRightRadius == 0) 0f else resources.getDimension(topRightRadius),
        if (topRightRadius == 0) 0f else resources.getDimension(topRightRadius),
        if (bottomLeftRadius == 0) 0f else resources.getDimension(bottomLeftRadius),
        if (bottomLeftRadius == 0) 0f else resources.getDimension(bottomLeftRadius),
        if (bottomRightRadius == 0) 0f else resources.getDimension(bottomRightRadius),
        if (bottomRightRadius == 0) 0f else resources.getDimension(bottomRightRadius),
    )
    val contentDrawable = GradientDrawable()
    contentDrawable.color = ContextCompat.getColorStateList(context, color)
    contentDrawable.cornerRadii = array
    val maskDrawable = GradientDrawable()
    maskDrawable.color = ColorStateList.valueOf(Color.BLACK)
    maskDrawable.cornerRadii = array
    val rippleDrawable = RippleDrawable(ColorStateList.valueOf(Color.parseColor("#cccccc")), contentDrawable, maskDrawable)
    ViewCompat.setBackground(this, rippleDrawable)
}