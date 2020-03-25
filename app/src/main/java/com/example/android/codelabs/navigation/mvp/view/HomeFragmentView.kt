package com.example.android.codelabs.navigation.mvp.view

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.mvp.contracts.HomeFragmentContracts

class HomeFragmentView : HomeFragmentContracts.View {

    private val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun destinationNextStep(context: Fragment) {
        NavHostFragment.findNavController(context).navigate(R.id.flow_step_one_dest, null, options)
    }

    override fun actionNextStep() = Navigation.createNavigateOnClickListener(R.id.next_action, null)

}