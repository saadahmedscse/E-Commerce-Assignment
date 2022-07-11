package com.saadahmedsoft.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.saadahmedsoft.base.utils.snackBar
import com.saadahmedsoft.base.utils.toast
import com.saadahmedsoft.e_commerce_assignment.utils.Constants
import com.saadahmedsoft.e_commerce_assignment.view.dashboard.DashboardActivity
import com.saadahmedsoft.e_commerce_assignment.viewmodel.ProductViewModel

abstract class BaseFragment<BINDING: ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> BINDING
) : Fragment() {

    private lateinit var _binding: BINDING

    val binding: BINDING
        get() = _binding

    abstract val title: String
    abstract val isBackButtonVisible: Boolean

    abstract fun onFragmentCreate(savedInstanceState: Bundle?)
    abstract fun observeData()

    private fun dashboardActivity() = (activity as DashboardActivity)
    val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        onFragmentCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardActivity().toolbarBinding?.toolbarTitle?.text = title
        dashboardActivity().toolbarBinding?.toolbarBtn?.visibility = if (isBackButtonVisible) View.VISIBLE else View.GONE
        return _binding.root
    }

    fun shortSnackBar(message: String) {
        showSnackBar(message, Constants.Durations.SNACK_SHORT)
    }

    fun longSnackBar(message: String) {
        showSnackBar(message, Constants.Durations.SNACK_LONG)
    }

    fun shortToast(message: String) {
        showToast(message, Constants.Durations.TOAST_SHORT)
    }

    fun longToast(message: String) {
        showToast(message, Constants.Durations.TOAST_LONG)
    }

    private fun showSnackBar(message: String, duration: Int) {
        snackBar(requireContext(), _binding.root, message, duration)
    }

    private fun showToast(message: String, duration: Int) {
        toast(requireContext(), message, duration)
    }

    fun onBackPressed() {
        requireActivity().onBackPressed()
    }
}