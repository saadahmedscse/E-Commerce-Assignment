package com.saadahmedsoft.e_commerce_assignment.utils

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.FALSE
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Theme.THEME_STATE
import com.saadahmedsoft.tinydb.TinyDB

object ThemeManager {
    fun getCurrentTheme(context: Context) {
        AppCompatDelegate.setDefaultNightMode(
            if (TinyDB.getInstance(context)
                    .getBoolean(THEME_STATE, FALSE)
            ) AppCompatDelegate.MODE_NIGHT_NO
            else AppCompatDelegate.MODE_NIGHT_YES
        )
    }
}