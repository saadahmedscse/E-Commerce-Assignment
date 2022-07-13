package com.saadahmedsoft.e_commerce_assignment.view.dashboard

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.navigation.NavGraph
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.saadahmedsoft.base.BaseActivity
import com.saadahmedsoft.base.utils.*
import com.saadahmedsoft.e_commerce_assignment.R
import com.saadahmedsoft.e_commerce_assignment.databinding.ActivityDashboardBinding
import com.saadahmedsoft.e_commerce_assignment.databinding.AppToolbarBinding
import com.saadahmedsoft.e_commerce_assignment.helper.delay
import com.saadahmedsoft.e_commerce_assignment.helper.handleRowException

class DashboardActivity : BaseActivity<ActivityDashboardBinding>(ActivityDashboardBinding::inflate) {

    override val toolbarBinding: AppToolbarBinding?
        get() = binding.appToolbar

    private lateinit var slideTop: Animation
    private lateinit var slideBottom: Animation

    private lateinit var myNavHostFragment: NavHostFragment
    private lateinit var dashboardGraph: NavGraph
    private lateinit var adminGraph: NavGraph

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        handleRowException()
        slideTop = AnimationUtils.loadAnimation(this, R.anim.slide_top)
        slideBottom = AnimationUtils.loadAnimation(this, R.anim.slide_bottom)

        binding.btnCustomer.onClicked {
            onCustomerTabClicked()
        }
        binding.btnAdmin.onClicked {
            onAdminTabClicked()
        }

        myNavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = myNavHostFragment.navController
        val inflater = navController.navInflater
        dashboardGraph = inflater.inflate(R.navigation.dashboard_graph)
        adminGraph = inflater.inflate(R.navigation.admin_graph)

        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(com.saadahmedsoft.shortintent.R.anim.animate_swipe_left_enter)
            .setExitAnim(com.saadahmedsoft.shortintent.R.anim.animate_swipe_left_exit)
            .setPopEnterAnim(com.saadahmedsoft.shortintent.R.anim.animate_swipe_right_enter)
            .setPopExitAnim(com.saadahmedsoft.shortintent.R.anim.animate_swipe_right_exit)
            .setPopUpTo(navController.graph.startDestinationId, false)
            .build()

        binding.navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    if (toolbarBinding?.toolbarTitle?.text != "Home") {
                        navController.navigate(R.id.homeFragment, null, options)
                    }
                }
                R.id.favoriteFragment -> {
                    if (toolbarBinding?.toolbarTitle?.text != "Favorite Products") {
                        navController.navigate(R.id.favoriteFragment, null, options)
                    }
                }
                R.id.settingsFragment -> {
                    if (toolbarBinding?.toolbarTitle?.text != "Settings") {
                        navController.navigate(R.id.settingsFragment, null, options)
                    }
                }
            }
            true
        }
    }

    override fun observeData() {}

    private fun onCustomerTabClicked() {
        binding.btnCustomer.setBackground(R.drawable.ripple_bg_main_5)
        binding.btnAdmin.setBackgroundColor(findColor(R.color.colorLightGrey))
        binding.btnCustomer.setTextColor(findColor(R.color.colorWhite))
        binding.btnAdmin.setTextColor(findColor(R.color.colorDarkGrey))
        myNavHostFragment.navController.graph = dashboardGraph

        if (!binding.navView.isVisible) {
            showBottomNav()
        }
    }

    private fun onAdminTabClicked() {
        binding.btnAdmin.setBackground(R.drawable.ripple_bg_main_5)
        binding.btnCustomer.setBackgroundColor(findColor(R.color.colorLightGrey))
        binding.btnAdmin.setTextColor(findColor(R.color.colorWhite))
        binding.btnCustomer.setTextColor(findColor(R.color.colorDarkGrey))
        myNavHostFragment.navController.graph = adminGraph

        if (binding.navView.isVisible) {
            hideBottomNav()
        }
    }

    private fun showBottomNav() {
        binding.navView.visible()
        binding.navView.startAnimation(slideTop)
    }

    private fun hideBottomNav() {
        binding.navView.startAnimation(slideBottom)
        delay(250) {
            binding.navView.invisible()
        }
    }

    fun setHomeButton() {
        binding.navView.selectedItemId = R.id.homeFragment
    }
}