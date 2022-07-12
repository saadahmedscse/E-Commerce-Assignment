package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.details

import android.os.Bundle
import com.saadahmedsoft.base.BaseActivity
import com.saadahmedsoft.base.utils.disable
import com.saadahmedsoft.base.utils.makeViewOnly
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.base.utils.visible
import com.saadahmedsoft.e_commerce_assignment.databinding.ActivityDetailsBinding
import com.saadahmedsoft.e_commerce_assignment.databinding.AppToolbarBinding
import com.saadahmedsoft.e_commerce_assignment.helper.stringToBitmap
import com.saadahmedsoft.e_commerce_assignment.services.model.ParcelableProduct
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Product.KEY_PRODUCT
import com.saadahmedsoft.tinydb.TinyDB

class DetailsActivity : BaseActivity<ActivityDetailsBinding>(ActivityDetailsBinding::inflate) {

    override val toolbarBinding: AppToolbarBinding
        get() = binding.appToolbar

    private var count = 1

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        toolbarBinding.toolbarBtn.visible()
        toolbarBinding.toolbarTitle.text = "Product Details"

        val item = TinyDB.getInstance(this)
            .getObject<ParcelableProduct>(KEY_PRODUCT, ParcelableProduct::class.java)
        binding.productImage.setImageBitmap(stringToBitmap(item.bitmap))
        binding.product = item
        binding.quantityVar = count.toString()

        binding.btnIncrease.onClicked {
            count++
            binding.quantityVar = count.toString()
        }

        binding.btnDecrease.onClicked {
            if (count != 1) {
                count--
                binding.quantityVar = count.toString()
            }
        }

        makeLayoutsViewOnly()
    }

    override fun observeData() {}

    private fun makeLayoutsViewOnly() {
        makeViewOnly(binding.colorLayout)
        makeViewOnly(binding.img1)
        makeViewOnly(binding.img2)
        makeViewOnly(binding.img3)
        makeViewOnly(binding.dummyTextPinned)
        makeViewOnly(binding.layoutCoupon)
        makeViewOnly(binding.btnAddToCart)
    }
}