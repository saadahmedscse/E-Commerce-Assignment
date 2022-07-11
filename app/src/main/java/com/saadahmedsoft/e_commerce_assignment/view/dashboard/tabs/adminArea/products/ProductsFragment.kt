package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.adminArea.products

import android.os.Bundle
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentProductsBinding
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.FALSE

class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {

    override val title: String
        get() = "Products"
    override val isBackButtonVisible: Boolean
        get() = FALSE

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun observeData() {}
}