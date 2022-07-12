package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.favorite

import android.os.Bundle
import android.view.View
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.base.BaseRecyclerAdapter
import com.saadahmedsoft.base.utils.gone
import com.saadahmedsoft.base.utils.visible
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentFavoriteBinding
import com.saadahmedsoft.e_commerce_assignment.helper.staggeredGridLayoutManager
import com.saadahmedsoft.e_commerce_assignment.services.model.Product
import com.saadahmedsoft.e_commerce_assignment.utils.Constants
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.TRUE
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Product.KEY_PRODUCT
import com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.details.DetailsActivity
import com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.home.adapter.ProductAdapter
import com.saadahmedsoft.shortintent.ShortIntent
import com.saadahmedsoft.tinydb.TinyDB

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate),
    BaseRecyclerAdapter.OnItemActionListener<Product> {

    override val title: String
        get() = "Favorite Products"
    override val isBackButtonVisible: Boolean
        get() = TRUE

    private val adapter by lazy {
        ProductAdapter(requireContext(), this)
    }

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = staggeredGridLayoutManager()

        viewModel.getFavorites().observe(this) {
            if (it.isEmpty()) {
                binding.layoutNoProduct.visible()
                binding.recyclerView.gone()
            } else {
                binding.recyclerView.visible()
                binding.layoutNoProduct.gone()

                binding.recyclerView.adapter = adapter
                adapter.addItems(it)
            }
        }
    }

    override fun observeData() {}

    override fun onItemClickListener(view: View, item: Product, position: Int) {
        TinyDB.getInstance(requireContext())
            .putObject(
                KEY_PRODUCT, item)
            .apply()

        ShortIntent.getInstance(requireActivity())
            .addDestination(DetailsActivity::class.java)
    }

    override fun onItemLongPressListener(view: View, item: Product, position: Int) {
        //
    }

    override fun onFavoriteClickListener(view: View, item: Product, position: Int) {
        viewModel.updateProduct(
            Product(
                id = item.id,
                bitmap = item.bitmap,
                name = item.name,
                category = item.category,
                price = item.price,
                description = item.description,
                isFavorite = if (item.isFavorite) Constants.Booleans.FALSE else TRUE
            )
        )
    }
}