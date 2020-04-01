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
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.codelabs.navigation.MY_ARG
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.mvp.contracts.DeepLinkContracts
import com.example.android.codelabs.navigation.mvp.presenter.DeepLinkPresenter
import com.example.android.codelabs.navigation.mvp.view.DeepLinkView
import kotlinx.android.synthetic.main.deeplink_fragment.args_edit_text
import kotlinx.android.synthetic.main.deeplink_fragment.send_notification_button
import kotlinx.android.synthetic.main.deeplink_fragment.text_deeplink

class DeepLinkFragment : Fragment() {

    private val presenter: DeepLinkContracts.Presenter = DeepLinkPresenter(DeepLinkView(this))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.deeplink_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_deeplink.text = arguments?.getString(MY_ARG)
        send_notification_button.setOnClickListener {
            presenter.onNotificationButtonClicked(args_edit_text.text.toString())
        }
    }
}
