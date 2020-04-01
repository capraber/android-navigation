package com.example.android.codelabs.navigation.mvp.presenter

import com.example.android.codelabs.navigation.mvp.contracts.DeepLinkContracts

class DeepLinkPresenter(private val view: DeepLinkContracts.View) : DeepLinkContracts.Presenter {
    override fun onNotificationButtonClicked(message: String) {
        view.pushNotification(message)
    }

}