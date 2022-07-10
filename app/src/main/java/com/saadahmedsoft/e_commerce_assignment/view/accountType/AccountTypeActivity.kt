package com.saadahmedsoft.e_commerce_assignment.view.accountType

import android.os.Bundle
import com.saadahmedsoft.base.BaseActivity
import com.saadahmedsoft.e_commerce_assignment.R
import com.saadahmedsoft.e_commerce_assignment.databinding.ActivityAccountTypeBinding
import com.saadahmedsoft.e_commerce_assignment.databinding.AppToolbarBinding

class AccountTypeActivity : BaseActivity<ActivityAccountTypeBinding>(ActivityAccountTypeBinding::inflate) {

    override val toolbarBinding: AppToolbarBinding?
        get() = null

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun observeData() {}

}