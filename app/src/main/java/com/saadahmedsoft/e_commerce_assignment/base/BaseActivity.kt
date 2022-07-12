package com.saadahmedsoft.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.base.utils.snackBar
import com.saadahmedsoft.base.utils.toast
import com.saadahmedsoft.e_commerce_assignment.databinding.AppToolbarBinding
import com.saadahmedsoft.e_commerce_assignment.helper.observe
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Durations.SNACK_LONG
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Durations.SNACK_SHORT
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Durations.TOAST_LONG
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Durations.TOAST_SHORT
import com.saadahmedsoft.e_commerce_assignment.viewmodel.ProductViewModel
import com.saadahmedsoft.e_commerce_assignment.viewmodel.ToolbarViewModel
import com.saadahmedsoft.shortintent.Animator

abstract class BaseActivity<BINDING: ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> BINDING
) : AppCompatActivity() {

    private lateinit var _binding: BINDING
    private val toolbarViewModel by viewModels<ToolbarViewModel>()
    val viewModel: ProductViewModel by viewModels()

    val binding: BINDING
        get() = _binding

    abstract val toolbarBinding: AppToolbarBinding?

    abstract fun onActivityCreate(savedInstanceState: Bundle?)

    abstract fun observeData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(_binding.root)
        observeData()
        initToolbar()
        onActivityCreate(savedInstanceState)
    }

    private fun initToolbar() {
        if (toolbarBinding != null) {
            observe(toolbarViewModel.title) {
                toolbarBinding?.toolbarTitle?.text = it
            }
            observe(toolbarViewModel.isBackButtonVisible) {
                toolbarBinding?.toolbarBtn?.visibility = if (it) View.VISIBLE else View.GONE
            }
            toolbarBinding?.toolbarBtn?.onClicked {
                super.onBackPressed()
                Animator.animateSlideDown(this)
            }
        }
    }

    fun shortSnackBar(message: String) {
        showSnackBar(message, SNACK_SHORT)
    }

    fun longSnackBar(message: String) {
        showSnackBar(message, SNACK_LONG)
    }

    fun shortToast(message: String) {
        showToast(message, TOAST_SHORT)
    }

    fun longToast(message: String) {
        showToast(message, TOAST_LONG)
    }

    private fun showSnackBar(message: String, duration: Int) {
        snackBar(this, _binding.root, message, duration)
    }

    private fun showToast(message: String, duration: Int) {
        toast(this, message, duration)
    }
}