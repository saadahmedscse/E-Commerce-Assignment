package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.adminArea.products

import android.os.Bundle
import android.view.View
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.base.BaseRecyclerAdapter
import com.saadahmedsoft.base.utils.gone
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.base.utils.visible
import com.saadahmedsoft.e_commerce_assignment.R
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentProductsBinding
import com.saadahmedsoft.e_commerce_assignment.helper.linearLayoutManager
import com.saadahmedsoft.e_commerce_assignment.helper.navigate
import com.saadahmedsoft.e_commerce_assignment.services.model.Product
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.FALSE
import com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.adminArea.products.adapter.ProductAdapter
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.CATEGORY
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.DESCRIPTION
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.ID
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.IMAGE
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.NAME
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.PRICE

class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate), BaseRecyclerAdapter.OnAdminItemActionListener<Product> {

    override val title: String
        get() = "Products"
    override val isBackButtonVisible: Boolean
        get() = FALSE

    private val adapter by lazy {
        ProductAdapter(requireContext(), this)
    }

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = linearLayoutManager(requireContext())

        binding.addBtn.onClicked {
            navigate(it, R.id.product_to_add_product)
        }
        binding.layoutAddProduct.onClicked {
            navigate(it, R.id.product_to_add_product)
        }

        viewModel.getProducts().observe(this) {
            if (it.isEmpty()) {
                binding.layoutAddProduct.visible()
                binding.addBtn.gone()
                binding.recyclerView.gone()
            }
            else {
                binding.recyclerView.visible()
                binding.addBtn.visible()
                binding.layoutAddProduct.gone()

                binding.recyclerView.adapter = adapter
                adapter.addItems(it)
            }
        }
    }

    override fun observeData() {}

    override fun onEditClickListener(view: View, item: Product, position: Int) {
        ID = item.id!!
        IMAGE = item.bitmap
        NAME = item.name
        CATEGORY = item.category
        PRICE = item.price
        DESCRIPTION = item.description
        navigate(view, R.id.product_to_edit_product)
    }

    override fun onDeleteClickListener(view: View, item: Product, position: Int) {
        viewModel.deleteProduct(item.id!!)
        shortSnackBar("Product deleted successfully")
    }
}