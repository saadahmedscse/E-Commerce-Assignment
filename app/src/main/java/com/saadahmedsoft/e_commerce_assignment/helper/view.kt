package com.saadahmedsoft.base.utils

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

infix fun View.onClicked(onClick: (View) -> Unit) {
    setOnClickListener { onClick(it) }
}

infix fun View.onLongPressed(onPress: (View) -> Boolean){
    setOnLongClickListener {onPress(it)}
}

fun View.findDrawable(@DrawableRes resId: Int): Drawable? =
    ContextCompat.getDrawable(context, resId)

fun Context.findDrawable(@DrawableRes resId: Int): Drawable? =
    ContextCompat.getDrawable(this, resId)

fun View.setBackground(@DrawableRes resId: Int) = setBackgroundResource(resId)

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