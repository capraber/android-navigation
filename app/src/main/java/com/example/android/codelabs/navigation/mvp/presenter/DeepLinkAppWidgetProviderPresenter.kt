package com.example.android.codelabs.navigation.mvp.presenter

import android.appwidget.AppWidgetManager
import android.content.Context
import com.example.android.codelabs.navigation.mvp.contracts.DeepLinkAppWidgetProviderContracts

class DeepLinkAppWidgetProviderPresenter(private val view: DeepLinkAppWidgetProviderContracts.View) : DeepLinkAppWidgetProviderContracts.Presenter{
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        view.updateDeepLink(context, appWidgetManager, appWidgetIds)
    }
}