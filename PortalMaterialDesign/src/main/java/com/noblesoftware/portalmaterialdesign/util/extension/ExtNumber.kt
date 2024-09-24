package com.noblesoftware.portalmaterialdesign.util.extension

import android.content.Context
import android.icu.number.Notation
import android.icu.number.NumberFormatter
import android.icu.text.CompactDecimalFormat
import android.icu.text.MessageFormat
import android.icu.text.NumberFormat
import android.os.Build
import com.noblesoftware.portalmaterialdesign.R
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.util.Locale
import kotlin.math.ln
import kotlin.math.pow

fun Int.toWords(language: String = "en", country: String = "US"): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        val formatter = MessageFormat(
            "{0,spellout,currency}",
            Locale(language, country)
        )
        formatter.format(arrayOf(this))
    } else {
        this.toString()
    }
}

fun Long.toRupiah(): String {
    val localeID = Locale("in", "ID")
    val numberFormat = java.text.NumberFormat.getCurrencyInstance(localeID)
    numberFormat.maximumFractionDigits = 0
    return numberFormat.format(this).toString()
}

fun Long.toCommaFormat(locale: Locale = Locale("in", "ID")): String {
    val numberFormat = NumberFormat.getInstance(locale)
    numberFormat.maximumFractionDigits = 0
    return numberFormat.format(this).toString()
}

fun Int?.orZero(): Int = this ?: 0
fun Double?.orZero(): Double = this ?: 0.0
fun Float?.orZero(): Float = this ?: 0f
fun Long?.orZero(): Long = this ?: 0
fun Int?.orStringEmpty(): Int = this ?: R.string.empty_string

fun Int.divideToPercent(divideTo: Int): Int {
    return if (divideTo == 0) 0
    else (this / divideTo.toFloat() * 100).toInt()
}

fun IntArray?.orEmpty(): IntArray = this ?: emptyArray<Int>().toIntArray()

fun Int?.orResourceStringEmpty(): Int = this ?: R.string.empty_string

fun Int?.orResourceStringWhiteSpace(): Int = this ?: R.string.empty_white_space

fun Int.toCurrency(): String = java.text.NumberFormat.getNumberInstance(Locale("in", "ID")).format(this)

fun Int?.ifNull(execute: () -> Int): Int {
    return this ?: execute.invoke()
}