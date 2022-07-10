package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.settings

import android.os.Bundle
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentSettingsBinding
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.TRUE

class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override val title: String
        get() = "Settings"
    override val isBackButtonVisible: Boolean
        get() = TRUE

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun observeData() {}
}