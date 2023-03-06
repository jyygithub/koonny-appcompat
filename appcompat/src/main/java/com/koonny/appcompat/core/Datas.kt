package com.koonny.appcompat.core

inline fun Boolean?.orDefault(): Boolean = this ?: false

inline fun Int?.orZero(default: Int = 0): Int = this ?: default

inline fun Long?.orZero(default: Long = 0L): Long = this ?: default

inline fun Float?.orZero(default: Float = 0f): Float = this ?: default

inline fun Double?.orZero(default: Double = 0.0): Double = this ?: default

inline fun String?.orDefault(default: String = ""): String = this ?: default

inline fun Long?.isNullOrZero(): Boolean = this == null || this == 0L

inline fun Int?.isNullOrZero(): Boolean = this == null || this == 0