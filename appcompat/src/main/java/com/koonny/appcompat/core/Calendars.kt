package com.koonny.appcompat.core

import java.text.SimpleDateFormat
import java.util.*

val NOW_MILLS = System.currentTimeMillis()
val NOW_DATE = Date()
val NOW_STRING = NOW_MILLS.formatString()

inline fun String.toDate(pattern: String = "yyyy-MM-dd HH:mm:ss") = SimpleDateFormat(pattern, Locale.getDefault()).parse(this)
inline fun Long.toDate() = Date(this)
inline fun String.toMillisecond(pattern: String = "yyyy-MM-dd HH:mm:ss") = toDate(pattern).time
inline fun Date.formatString(pattern: String = "yyyy-MM-dd HH:mm:ss") = SimpleDateFormat(pattern, Locale.getDefault()).format(this)
inline fun Long.formatString(pattern: String = "yyyy-MM-dd HH:mm:ss") = SimpleDateFormat(pattern, Locale.getDefault()).format(this)
