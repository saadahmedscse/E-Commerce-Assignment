package com.saadahmedsoft.base.utils

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

infix fun View.onClicked(onClick: (View) -> Unit) {
    setOnClickListener { onClick(it) }
}

infix fun View.onLongPressed(onPress: (View) -> Boolean){
    setOnLongClickListener {onPress(it)}
}

fun View.findColor(@ColorRes resId: Int) = ContextCompat.getColor(context, resId)
fun Context.findColor(@ColorRes resId: Int) = ContextCompat.getColor(this, resId)
fun Activity.findColor(@ColorRes resId: Int) = ContextCompat.getColor(this, resId)
fun Fragment.findColor(@ColorRes resId: Int) = ContextCompat.getColor(context!!, resId)

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.enable() {
    this.isEnabled = true
    this.alpha = 1f
}

fun View.disable() {
    this.isEnabled = false
    this.alpha = 0.4.toFloat()
}