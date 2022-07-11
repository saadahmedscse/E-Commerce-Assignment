package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.adminArea.products.adapter

import android.content.Context
import com.saadahmedsoft.base.BaseRecyclerAdapter
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.e_commerce_assignment.R
import com.saadahmedsoft.e_commerce_assignment.databinding.ItemProductAdminBinding
import com.saadahmedsoft.e_commerce_assignment.helper.stringToBitmap
import com.saadahmedsoft.e_commerce_assignment.services.model.Product

class ProductAdapter(val context: Context, private val listener: OnAdminItemActionListener<Product>) : BaseRecyclerAdapter<Product, ItemProductAdminBinding>() {
    override val layoutRes: Int
        get() = R.layout.item_product_admin

    override fun onBind(binding: ItemProductAdminBinding, item: Product, position: Int) {
        binding.productImage.setImageBitmap(stringToBitmap(item.bitmap))
        binding.product = item

        binding.btnEdit.onClicked {
            listener.onEditClickListener(it, item, position)
        }

        binding.btnDelete.onClicked {
            listener.onDeleteClickListener(it, item, position)
        }
    }
}