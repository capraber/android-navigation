package com.example.android.codelabs.navigation.mvp

import android.view.View.OnClickListener
import androidx.navigation.NavOptions
import com.example.android.codelabs.navigation.fragments.HomeFragment

interface HomeFragmentContracts {
    interface Presenter {
        fun destinationNextStep(context: HomeFragment)
        fun actionNextStep(): OnClickListener
    }

    interface View {
        fun getAnimation() : NavOptions
    }
}