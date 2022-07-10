package com.saadahmedsoft.e_commerce_assignment.view.dashboard

import android.os.Bundle
import com.saadahmedsoft.base.BaseActivity
import com.saadahmedsoft.e_commerce_assignment.R
import com.saadahmedsoft.e_commerce_assignment.databinding.ActivityDashboardBinding
import com.saadahmedsoft.e_commerce_assignment.databinding.AppToolbarBinding

class DashboardActivity : BaseActivity<ActivityDashboardBinding>(ActivityDashboardBinding::inflate) {

    override val toolbarBinding: AppToolbarBinding?
        get() = binding.appToolbar

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun observeData() {}
}