package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.adminArea.editProduct

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentAddProductBinding
import com.saadahmedsoft.e_commerce_assignment.helper.bitmapToString
import com.saadahmedsoft.e_commerce_assignment.helper.stringToBitmap
import com.saadahmedsoft.e_commerce_assignment.services.model.Product
import com.saadahmedsoft.e_commerce_assignment.utils.Constants
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.CATEGORY
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.DESCRIPTION
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.ID
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.IMAGE
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.NAME
import com.saadahmedsoft.e_commerce_assignment.view.utils.VARs.Product.PRICE

class EditProductFragment : BaseFragment<FragmentAddProductBinding>(FragmentAddProductBinding::inflate) {

    override val title: String
        get() = "Edit Product"
    override val isBackButtonVisible: Boolean
        get() = Constants.Booleans.TRUE

    private var image = ""
    private var name = ""
    private var category = ""
    private var price = ""
    private var description = ""

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        binding.btnAddProduct.text = "Update Product"

        image = IMAGE
        name = NAME
        category = CATEGORY
        price = PRICE
        description = DESCRIPTION

        binding.imgAddImage.setImageBitmap(stringToBitmap(image))
        binding.etProductName.setText(name)
        binding.etProductCategory.setText(category)
        binding.etProductPrice.setText(price)
        binding.etProductDescription.setText(description)

        binding.imgAddImage.onClicked {
            if (ContextCompat.checkSelfPermission(requireContext(), READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(
                    READ_EXTERNAL_STORAGE), 1)
            }
            else {
                openFileChooser()
            }
        }

        binding.btnAddProduct.onClicked {
            initialize()
            if (validate()) {
                viewModel.updateProduct(getProduct())
                shortSnackBar("Product updated successfully")
                onBackPressed()
            }
        }
    }

    override fun observeData() {}

    private fun initialize() {
        name = binding.etProductName.text.toString()
        category = binding.etProductCategory.text.toString()
        price = binding.etProductPrice.text.toString()
        description = binding.etProductDescription.text.toString()
    }

    private fun validate(): Boolean {
        if (name.isEmpty() || category.isEmpty() || price.isEmpty() || description.isEmpty()) {
            shortSnackBar("Filed cannot be empty")
            return false
        }
        return true
    }

    private fun getProduct(): Product {
        return Product(
            ID,
            bitmapToString((binding.imgAddImage.drawable as BitmapDrawable).bitmap),
            name,
            category,
            price,
            description
        )
    }

    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                binding.imgAddImage.setImageURI(data.data)
                image = "Selected"
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openFileChooser()
            }
            else {
                shortSnackBar("You have to allow permission")
            }
        }
    }
}