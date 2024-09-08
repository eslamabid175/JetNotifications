package com.eslam.jetnotifications

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

fun custom(context: Context) {

    val smallCustomView = RemoteViews(context.packageName, R.layout.small_custom_layout)
    val customView = RemoteViews(context.packageName, R.layout.custom_layout)

    val intent = Intent(context, CustomReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(
        context, 5, intent, PendingIntent.FLAG_IMMUTABLE
    )
    customView.setOnClickPendingIntent(R.id.notification_button,pendingIntent)

    val notification = NotificationCompat.Builder(context, DEFAULT)
        .setCustomContentView(smallCustomView)
        .setCustomBigContentView(customView)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .build()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(14, notification)
        }
    } else {
        NotificationManagerCompat.from(context).notify(14, notification)
    }


}


class CustomReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "custom", Toast.LENGTH_LONG).show()
    }
}