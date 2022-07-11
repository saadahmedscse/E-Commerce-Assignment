package com.saadahmedsoft.e_commerce_assignment.utils

import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Constants {
    object App {
        const val APP_NAME = "E-Commerce Assignment"
    }

    object Theme {
        const val THEME_STATE = "THEME_STATE"
    }

    object Booleans {
        const val TRUE = true
        const val FALSE = false
    }

    object Durations {
        const val SNACK_SHORT = Snackbar.LENGTH_SHORT
        const val SNACK_LONG = Snackbar.LENGTH_LONG
        const val TOAST_SHORT = Toast.LENGTH_SHORT
        const val TOAST_LONG = Toast.LENGTH_LONG
    }

    object Database {
        const val TABLE_NAME = "Product_Table"
    }

    object Product {
        const val KEY_PRODUCT = "Product_Key"
    }
}