package com.example.android.codelabs.navigation.mvp.contracts

import android.view.Menu
import android.view.MenuItem


interface MainActivityContracts {
    interface View {
        fun init()
        fun setupBottomNavMenu()
        fun setupNavigationMenu()
        fun setupActionBar()
        fun destinationChangedListener()
        fun onCreateOptionsMenu(menu: Menu): Boolean
        fun onOptionsItemSelected(item: MenuItem): Boolean
        fun onSupportNavigateUp(): Boolean
    }

    interface Presenter {
        fun init()
        fun onCreateOptionsMenu(menu: Menu): Boolean
        fun onOptionsItemSelected(item: MenuItem): Boolean
        fun onSupportNavigateUp(): Boolean
    }
}