package com.example.android.codelabs.navigation.mvp.view

import androidx.navigation.navOptions
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.mvp.HomeFragmentContracts

class HomeFragmentView : HomeFragmentContracts.View {
    private val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun getAnimation() = options
}