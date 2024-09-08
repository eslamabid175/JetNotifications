package com.eslam.jetnotifications


import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

fun bigTextStyle(context: Context) {

    val style = NotificationCompat.BigTextStyle()
        .setSummaryText("summary")
        .setBigContentTitle("Big title")
        .bigText(context.getString(R.string.android))

    val notification = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("title")
        .setContentText("desc")
        .setStyle(style)
        .build()


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(9, notification)
        }
    } else {
        NotificationManagerCompat.from(context).notify(9, notification)
    }

}


fun bigPictureStyle(context: Context) {

    val style = NotificationCompat.BigPictureStyle()
        .setSummaryText("summary")
        .setBigContentTitle("Big title")
        .bigPicture(BitmapFactory.decodeResource(context.resources, R.drawable.big_image))

    val notification = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("title")
        .setContentText("desc")
        .setStyle(style)
        .build()


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(9, notification)
        }
    } else {
        NotificationManagerCompat.from(context).notify(9, notification)
    }

}


fun inBoxStyle(context: Context) {

    val style = NotificationCompat.InboxStyle()
        .setSummaryText("summary")
        .setBigContentTitle("Big title")
        .addLine("first line")
        .addLine("second line")

    val notification = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("title")
        .setContentText("desc")
        .setStyle(style)
        .build()


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(9, notification)
        }
    } else {
        NotificationManagerCompat.from(context).notify(9, notification)
    }

}