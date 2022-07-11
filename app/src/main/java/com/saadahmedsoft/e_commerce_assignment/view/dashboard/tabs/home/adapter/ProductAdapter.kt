package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.home.adapter

import android.content.Context
import com.saadahmedsoft.base.BaseRecyclerAdapter
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.base.utils.onLongPressed
import com.saadahmedsoft.e_commerce_assignment.R
import com.saadahmedsoft.e_commerce_assignment.databinding.ItemProductHomeBinding
import com.saadahmedsoft.e_commerce_assignment.helper.stringToBitmap
import com.saadahmedsoft.e_commerce_assignment.services.model.Product

class ProductAdapter(val context: Context, private val listener: OnItemActionListener<Product>) : BaseRecyclerAdapter<Product, ItemProductHomeBinding>() {
    override val layoutRes: Int
        get() = R.layout.item_product_home

    override fun onBind(binding: ItemProductHomeBinding, item: Product, position: Int) {
        binding.productImage.setImageBitmap(stringToBitmap(item.bitmap))
        binding.productName.text = item.name
        binding.productPrice.text = "${item.price}$"

        binding.root.onClicked {
            listener.onItemClickListener(it, item, position)
        }

        binding.root.onLongPressed {
            listener.onItemLongPressListener(it, item, position)
            true
        }
    }
}