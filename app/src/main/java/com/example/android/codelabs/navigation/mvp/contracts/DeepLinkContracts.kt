package com.example.android.codelabs.navigation.mvp.contracts

interface DeepLinkContracts {
    interface View {
        fun pushNotification(message: String)
    }
    interface Presenter {
        fun onNotificationButtonClicked(message: String)
    }
}