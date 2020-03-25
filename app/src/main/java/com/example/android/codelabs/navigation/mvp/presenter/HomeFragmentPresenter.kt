package com.example.android.codelabs.navigation.mvp.presenter

import android.view.View
import androidx.fragment.app.Fragment
import com.example.android.codelabs.navigation.mvp.contracts.HomeFragmentContracts

class HomeFragmentPresenter(private val view: HomeFragmentContracts.View) : HomeFragmentContracts.Presenter {

    override fun destinationNextStep(context: Fragment) {
        view.destinationNextStep(context)
    }
    override fun actionNextStep(): View.OnClickListener = view.actionNextStep()
}