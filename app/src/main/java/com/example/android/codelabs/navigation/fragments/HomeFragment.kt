/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.mvp.presenter.HomeFragmentPresenter
import com.example.android.codelabs.navigation.mvp.view.HomeFragmentView
import kotlinx.android.synthetic.main.home_fragment.navigate_action_button
import kotlinx.android.synthetic.main.home_fragment.navigate_destination_button

/**
 * Fragment used to show how to navigate to another destination
 */
class HomeFragment : Fragment() {

    private val presenter = HomeFragmentPresenter(HomeFragmentView())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate_destination_button.setOnClickListener { presenter.destinationNextStep(this) }
        navigate_action_button.setOnClickListener(presenter.actionNextStep())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}
