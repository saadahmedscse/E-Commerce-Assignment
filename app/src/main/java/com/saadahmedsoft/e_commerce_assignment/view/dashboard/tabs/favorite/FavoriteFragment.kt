package com.saadahmedsoft.e_commerce_assignment.view.dashboard.tabs.favorite

import android.os.Bundle
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.e_commerce_assignment.databinding.FragmentFavoriteBinding
import com.saadahmedsoft.e_commerce_assignment.utils.Constants.Booleans.TRUE

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    override val title: String
        get() = "Favorite Products"
    override val isBackButtonVisible: Boolean
        get() = TRUE

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun observeData() {}
}