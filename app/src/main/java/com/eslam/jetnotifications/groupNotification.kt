package com.eslam.jetnotifications

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

const val GROUP = "group"

fun groupNotification(context: Context) {

    val notification = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_reply_24)
        .setContentTitle("first title")
        .setContentText("first desc")
        .setGroup(GROUP)
        .build()

    val secondNotification = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_play)
        .setContentTitle("second title")
        .setContentText("second desc")
        .setGroup(GROUP)
        .build()

    val groupBuilder = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("group title")
        .setContentText("group text")
        .setGroup(GROUP)
        .setGroupSummary(true)
        .build()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).apply {
                notify(4,notification)
                notify(5,secondNotification)
                notify(6,groupBuilder)
            }
        }
    }else{
        NotificationManagerCompat.from(context).apply {
            notify(4,notification)
            notify(5,secondNotification)
            notify(6,groupBuilder)
        }
    }




}