package com.noblesoftware.portalmaterialdesign.util.extension

fun Boolean?.orFalse(): Boolean = this ?: false
fun Boolean.isFalse() = !this
fun Boolean?.isTrue() = this.orFalse()