package com.koonny.appcompat.core

import java.text.SimpleDateFormat
import java.util.*

val NOW_MILLS = System.currentTimeMillis()
val NOW_DATE = Date()
val NOW_STRING = NOW_MILLS.mills2string()

inline fun String.string2date(pattern: String = "yyyy-MM-dd HH:mm:ss") = SimpleDateFormat(pattern, Locale.getDefault()).parse(this)
inline fun String.string2mills(pattern: String = "yyyy-MM-dd HH:mm:ss") = string2date(pattern).time
inline fun Date.date2string(pattern: String = "yyyy-MM-dd HH:mm:ss") = SimpleDateFormat(pattern, Locale.getDefault()).format(this)
inline fun Long.mills2string(pattern: String = "yyyy-MM-dd HH:mm:ss") = SimpleDateFormat(pattern, Locale.getDefault()).format(this)
inline fun Date.date2mills() = this.time
inline fun Long.mills2date() = Date(this)
