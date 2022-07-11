package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.base.BaseRecyclerAdapter
import com.saadahmedsoft.base.utils.gone
import com.saadahmedsoft.base.utils.visible
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentHomeBinding
import com.saadahmedsoft.e_commerce_assignment.helper.staggeredGridLayoutManager
import com.saadahmedsoft.e_commerce_assignment.services.model.Product
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.FALSE
import com.saadahmedsoft.e_commerce_assignment.view.dashboard.DashboardActivity
import com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.home.adapter.ProductAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), BaseRecyclerAdapter.OnItemActionListener<Product> {

    override val title: String
        get() = "Home"
    override val isBackButtonVisible: Boolean
        get() = FALSE

    private val adapter by lazy {
        ProductAdapter(requireContext(), this)
    }

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = staggeredGridLayoutManager()

        viewModel.getProducts().observe(this) {
            if (it.isEmpty()) {
                binding.layoutNoProduct.visible()
                binding.recyclerView.gone()
            }
            else {
                binding.recyclerView.visible()
                binding.layoutNoProduct.gone()

                binding.recyclerView.adapter = adapter
                adapter.addItems(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as DashboardActivity).setHomeButton()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun observeData() {}

    override fun onItemClickListener(view: View, item: Product, position: Int) {
        //
    }

    override fun onItemLongPressListener(view: View, item: Product, position: Int) {
        //
    }
}