package com.saadahmedsoft.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.saadahmedsoft.base.utils.snackBar
import com.saadahmedsoft.base.utils.toast
import com.saadahmedsoft.e_commerce_assignment.utils.Constants
import kotlin.properties.Delegates

abstract class BaseFragment<BINDING: ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> BINDING
) : Fragment() {

    object FragmentPage {
        lateinit var TITLE: String
        var IS_BACK_BUTTON_VISIBLE by Delegates.notNull<Boolean>()
    }

    private lateinit var _binding: BINDING

    val binding: BINDING
        get() = _binding

    abstract val title: String
    abstract val isBackButtonVisible: Boolean

    abstract fun onFragmentCreate(savedInstanceState: Bundle?)
    abstract fun observeData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        FragmentPage.TITLE = title
        FragmentPage.IS_BACK_BUTTON_VISIBLE = isBackButtonVisible
        onFragmentCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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