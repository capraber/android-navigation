package com.example.android.codelabs.navigation.mvp.presenter

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.android.codelabs.navigation.mvp.contracts.MainActivityContracts

class MainActivityPresenter(private val view: MainActivityContracts.View) : MainActivityContracts.Presenter{
    override fun init() {
        view.init()
        view.setupActionBar()
        view.setupBottomNavMenu()
        view.setupNavigationMenu()
        view.destinationChangedListener()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return view.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        return view.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return view.onOptionsItemSelected(item)
    }
}