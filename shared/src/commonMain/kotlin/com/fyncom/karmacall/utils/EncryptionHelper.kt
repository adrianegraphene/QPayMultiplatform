package com.fyncom.karmacall.utils

fun String.encrypt() = this.onEach { it.plus(5) }
fun String.decrypt() = this.onEach { it.minus(5) }
