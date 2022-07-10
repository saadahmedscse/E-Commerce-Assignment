package com.saadahmedsoft.e_commerce_assignment.app

import android.app.Application
import com.saadahmedsoft.e_commerce_assignment.utils.ThemeManager

class ECommerceAssignment : Application() {
    override fun onCreate() {
        super.onCreate()
        ThemeManager.getCurrentTheme(this)
    }
}