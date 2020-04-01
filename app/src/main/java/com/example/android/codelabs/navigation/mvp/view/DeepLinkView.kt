package com.example.android.codelabs.navigation.mvp.view

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.codelabs.navigation.DEEPLINK_ID
import com.example.android.codelabs.navigation.DEEP_LINKS
import com.example.android.codelabs.navigation.ID
import com.example.android.codelabs.navigation.MY_ARG
import com.example.android.codelabs.navigation.NAVIGATION_TITLE
import com.example.android.codelabs.navigation.NOTIFICATION_CONTENT
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.mvp.contracts.DeepLinkContracts
import java.lang.ref.WeakReference

class DeepLinkView(context: Fragment) : DeepLinkContracts.View {

    private val fragment = WeakReference(context).get()
    private val args = Bundle()
    private lateinit var deepLink: PendingIntent
    private lateinit var notificationManager: NotificationManager
    private lateinit var builder: NotificationCompat.Builder

    private fun setDeepLink() {
        fragment?.run {
            deepLink = findNavController().createDeepLink()
                .setDestination(R.id.deeplink_dest)
                .setArguments(args)
                .createPendingIntent()
        }
    }

    private fun setNotificationManager() {
        fragment?.context?.run {
            notificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(NotificationChannel(
                    DEEPLINK_ID, DEEP_LINKS, NotificationManager.IMPORTANCE_HIGH))
            }
        }
    }

    private fun setNotificationBuilder(message: String) {
        fragment?.context?.run {
            val builder = NotificationCompat.Builder(this, DEEPLINK_ID)
                .setContentTitle(NAVIGATION_TITLE)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(deepLink)
                .setAutoCancel(true)
            notificationManager.notify(ID, builder.build())
        }
    }

    override fun pushNotification(message: String) {
        args.putString(MY_ARG, message)
        setDeepLink()
        setNotificationManager()
        setNotificationBuilder(message)
    }
}