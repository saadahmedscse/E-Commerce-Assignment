package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentSettingsBinding
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.FALSE
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.TRUE
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Theme.THEME_STATE
import com.saadahmedsoft.tinydb.TinyDB

class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override val title: String
        get() = "Settings"
    override val isBackButtonVisible: Boolean
        get() = TRUE

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        val db = TinyDB.getInstance(requireContext())
        binding.btnThemeChange.onClicked {
            val state = db.getBoolean(
                THEME_STATE,
                FALSE
            )

            if (state) {
                db.putBoolean(THEME_STATE, FALSE)
                    .apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                db.putBoolean(THEME_STATE, TRUE)
                    .apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    override fun observeData() {}
}