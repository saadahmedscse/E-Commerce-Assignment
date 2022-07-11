package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.adminArea.products

import android.os.Bundle
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.e_commerce_assignment.R
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentProductsBinding
import com.saadahmedsoft.e_commerce_assignment.helper.navigate
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.FALSE

class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {

    override val title: String
        get() = "Products"
    override val isBackButtonVisible: Boolean
        get() = FALSE

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        binding.addBtn.onClicked {
            navigate(it, R.id.product_to_add_product)
        }
        binding.layoutAddProduct.onClicked {
            navigate(it, R.id.product_to_add_product)
        }
    }

    override fun observeData() {}
}