package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentHomeBinding
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.FALSE
import com.saadahmedsoft.e_commerce_assignment.view.dashboard.DashboardActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val title: String
        get() = "Home"
    override val isBackButtonVisible: Boolean
        get() = FALSE

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as DashboardActivity).setHomeButton()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun observeData() {}
}