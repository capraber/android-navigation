package com.example.android.codelabs.navigation.mvp.presenter

import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.fragments.HomeFragment
import com.example.android.codelabs.navigation.mvp.HomeFragmentContracts

class HomeFragmentPresenter(private val view: HomeFragmentContracts.View) : HomeFragmentContracts.Presenter {

    override fun destinationNextStep(context: HomeFragment) {
        findNavController(context).navigate(R.id.flow_step_one_dest, null, view.getAnimation())
    }
    override fun actionNextStep() = Navigation.createNavigateOnClickListener(R.id.next_action, null)
}