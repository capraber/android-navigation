package com.example.android.codelabs.navigation.mvp.view

import android.content.res.Resources
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.android.codelabs.navigation.MainActivity
import com.example.android.codelabs.navigation.NAVIGATED_TO
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.mvp.contracts.MainActivityContracts
import kotlinx.android.synthetic.main.navigation_activity.bottom_nav_view
import kotlinx.android.synthetic.main.navigation_activity.drawer_layout
import kotlinx.android.synthetic.main.navigation_activity.nav_view
import kotlinx.android.synthetic.main.navigation_activity.toolbar
import java.lang.ref.WeakReference

class MainActivityView(context: MainActivity) : MainActivityContracts.View {
    private val activity = WeakReference(context).get()
    private lateinit var host: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun init() {
        activity?.setSupportActionBar(activity.toolbar)
        host = activity?.supportFragmentManager?.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navController = host.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.home_dest, R.id.deeplink_dest), activity.drawer_layout)
    }

    override fun setupBottomNavMenu() {
        activity?.bottom_nav_view?.setupWithNavController(navController)
    }

    override fun setupNavigationMenu() {
        activity?.nav_view?.setupWithNavController(navController)
    }

    override fun setupActionBar() {
        activity?.run {
            setupActionBarWithNavController(this, navController, appBarConfiguration)
        }
    }

    override fun destinationChangedListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            activity?.run {
                val dest: String = try {
                    resources.getResourceName(destination.id)
                } catch (e: Resources.NotFoundException) {
                    destination.id.toString()
                }
                navigationToast(dest)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        activity?.nav_view?.run {
            return false
        }
        activity?.menuInflater?.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        activity?.run {
                return item.onNavDestinationSelected(findNavController(this, R.id.my_nav_host_fragment))
        }
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        activity?.run {
            return findNavController(this, R.id.my_nav_host_fragment).navigateUp(appBarConfiguration)
        }
        return false
    }

    private fun navigationToast(dest: String) {
        Toast.makeText(activity, "${R.string.navigated_to}$dest", Toast.LENGTH_SHORT).show()
    }
}