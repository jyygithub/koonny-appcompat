package com.koonny.appcompat.core

import java.util.regex.Pattern

fun CharSequence?.isMatch(regex: String): Boolean {
    return !this.isNullOrEmpty() && Pattern.matches(regex, this)
}

private const val REGEX_MOBILE_EXACT =
    "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(16[6])|(17[0,1,3,5-8])|(18[0-9])|(19[8,9]))\\d{8}$"
private const val REGEX_PASSWORD = "^(?![0-9])(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$"
private const val REGEX_MOBILE_MASKING = "^(\\d{3})\\d{4}(\\d{3})"

val CharSequence?.isPhoneNumber: Boolean
    get() = this.isMatch(REGEX_MOBILE_EXACT)

val CharSequence?.isPassword: Boolean
    get() = this.isMatch(REGEX_PASSWORD)

val CharSequence?.maskingMobile: CharSequence?
    get() = if (this.isPhoneNumber) this!!.replace(REGEX_MOBILE_MASKING.toRegex(), "$1****$2") else this