package com.eslam.jetnotifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

const val DEFAULT = "default"
const val DEFAULT_NAME = "default_name"

const val SILENT = "silent"
const val SILENT_NAME = "silent_name"

const val URGENT = "urgent"
const val URGENT_NAME = "urgent_name"

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(DEFAULT, DEFAULT_NAME, NotificationManager.IMPORTANCE_DEFAULT)

            val silentChannel =
                NotificationChannel(SILENT, SILENT_NAME, NotificationManager.IMPORTANCE_LOW)

            val urgentChannel =
                NotificationChannel(URGENT, URGENT_NAME, NotificationManager.IMPORTANCE_HIGH)

            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(silentChannel)
            notificationManager.createNotificationChannel(urgentChannel)
        }
    }

}