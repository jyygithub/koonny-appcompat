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
    drawable.cornerRadius = resources.getDimension(radius)
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

fun View.setGradientRes(@ColorRes color: Int, @DimenRes topLeftRadius: Int, @DimenRes topRightRadius: Int, @DimenRes bottomLeftRadius: Int, @DimenRes bottomRightRadius: Int) {
    val cornerRadii = floatArrayOf(
        resources.getDimension(topLeftRadius),
        resources.getDimension(topLeftRadius),
        resources.getDimension(topRightRadius),
        resources.getDimension(topRightRadius),
        resources.getDimension(bottomLeftRadius),
        resources.getDimension(bottomLeftRadius),
        resources.getDimension(bottomRightRadius),
        resources.getDimension(bottomRightRadius),
    )
    val drawable = GradientDrawable()
    drawable.color = ContextCompat.getColorStateList(context, color)
    drawable.cornerRadii = cornerRadii
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
    contentDrawable.cornerRadius = resources.getDimension(radius)
    val maskDrawable = GradientDrawable()
    maskDrawable.color = ColorStateList.valueOf(Color.BLACK)
    maskDrawable.cornerRadius = resources.getDimension(radius)
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

fun View.setRippleRes(
    @ColorRes color: Int,
    @DimenRes topLeftRadius: Int,
    @DimenRes topRightRadius: Int,
    @DimenRes bottomLeftRadius: Int,
    @DimenRes bottomRightRadius: Int
) {
    val cornerRadii = floatArrayOf(
        resources.getDimension(topLeftRadius),
        resources.getDimension(topLeftRadius),
        resources.getDimension(topRightRadius),
        resources.getDimension(topRightRadius),
        resources.getDimension(bottomLeftRadius),
        resources.getDimension(bottomLeftRadius),
        resources.getDimension(bottomRightRadius),
        resources.getDimension(bottomRightRadius),
    )
    val contentDrawable = GradientDrawable()
    contentDrawable.color = ContextCompat.getColorStateList(context, color)
    contentDrawable.cornerRadii = cornerRadii
    val maskDrawable = GradientDrawable()
    maskDrawable.color = ColorStateList.valueOf(Color.BLACK)
    maskDrawable.cornerRadii = cornerRadii
    val rippleDrawable = RippleDrawable(ColorStateList.valueOf(Color.parseColor("#cccccc")), contentDrawable, maskDrawable)
    ViewCompat.setBackground(this, rippleDrawable)
}