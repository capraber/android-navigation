package com.example.android.codelabs.navigation.mvp.contracts

import android.view.View.OnClickListener
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions

interface HomeFragmentContracts {
    interface Presenter {
        fun destinationNextStep(context: Fragment)
        fun actionNextStep(): OnClickListener
    }

    interface View {
        fun destinationNextStep(context: Fragment)
        fun actionNextStep(): OnClickListener
    }

}