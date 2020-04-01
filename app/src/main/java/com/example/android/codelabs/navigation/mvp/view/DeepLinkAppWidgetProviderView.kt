package com.example.android.codelabs.navigation.mvp.view

import android.appwidget.AppWidgetManager
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder
import com.example.android.codelabs.navigation.MY_ARG
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.mvp.contracts.DeepLinkAppWidgetProviderContracts

class DeepLinkAppWidgetProviderView : DeepLinkAppWidgetProviderContracts.View {
    override fun updateDeepLink(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val remoteViews = RemoteViews(context.packageName, R.layout.deep_link_appwidget)
        val args = Bundle()
        args.putString(MY_ARG, context.resources.getString(R.string.from_widget))
        val pendingIntent = NavDeepLinkBuilder(context)
            .setGraph(R.navigation.mobile_navigation)
            .setDestination(R.id.deeplink_dest)
            .setArguments(args)
            .createPendingIntent()
        remoteViews.setOnClickPendingIntent(R.id.deep_link_button, pendingIntent)
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }

}