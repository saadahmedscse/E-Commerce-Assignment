package com.saadahmedsoft.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.saadahmedsoft.base.utils.onClicked
import com.saadahmedsoft.base.utils.snackBar
import com.saadahmedsoft.base.utils.toast
import com.saadahmedsoft.e_commerce_assignment.databinding.AppToolbarBinding
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Durations.SNACK_LONG
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Durations.SNACK_SHORT
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Durations.TOAST_LONG
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Durations.TOAST_SHORT
import com.saadahmedsoft.shortintent.Animator

abstract class BaseActivity<BINDING: ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> BINDING
) : AppCompatActivity() {

    private lateinit var _binding: BINDING

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
            toolbarBinding?.toolbarTitle?.text = BaseFragment.FragmentPage.TITLE
            toolbarBinding?.toolbarBtn?.visibility = if (BaseFragment.FragmentPage.IS_BACK_BUTTON_VISIBLE) View.VISIBLE else View.GONE
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