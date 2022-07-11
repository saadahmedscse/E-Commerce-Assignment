package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.adminArea.addProduct

import android.os.Bundle
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentAddProductBinding
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.TRUE

class AddProductFragment : BaseFragment<FragmentAddProductBinding>(FragmentAddProductBinding::inflate) {

    override val title: String
        get() = "Add Product"
    override val isBackButtonVisible: Boolean
        get() = TRUE

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun observeData() {}
}