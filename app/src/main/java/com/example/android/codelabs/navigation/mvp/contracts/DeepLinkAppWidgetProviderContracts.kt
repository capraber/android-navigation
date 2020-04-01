package com.example.android.codelabs.navigation.mvp.contracts

import android.appwidget.AppWidgetManager
import android.content.Context

interface DeepLinkAppWidgetProviderContracts {
    interface View {
        fun updateDeepLink(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray)
    }
    interface Presenter {
        fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray)
    }
}