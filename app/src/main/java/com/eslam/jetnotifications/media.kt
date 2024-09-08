package com.eslam.jetnotifications

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

fun media(context: Context) {

    val style = androidx.media.app.NotificationCompat.MediaStyle()
        .setShowActionsInCompactView(0, 1, 2)

    val playPauseIntent = Intent(context, Next::class.java)
    val playAndPause = PendingIntent.getBroadcast(
        context, 4, playPauseIntent, PendingIntent.FLAG_MUTABLE
    )

    val prevIntent = Intent(context, Next::class.java)
    val prev = PendingIntent.getBroadcast(
        context, 5, prevIntent, PendingIntent.FLAG_MUTABLE
    )

    val nextIntent = Intent(context, Next::class.java)
    val next = PendingIntent.getBroadcast(
        context, 6, nextIntent, PendingIntent.FLAG_MUTABLE
    )

    val notification = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("title")
        .setContentText("desc")
        .addAction(R.drawable.ic_next_24, "next", next)
        .addAction(R.drawable.ic_previous_24, "prev", prev)
        .addAction(R.drawable.ic_play, "play", playAndPause)
        .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.big_image))
        .setStyle(style)
        .build()


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(12,notification)
        }
    }else{
        NotificationManagerCompat.from(context).notify(12,notification)
    }
}


class Next : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "next", Toast.LENGTH_LONG).show()
    }
}

class Prev : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "prev", Toast.LENGTH_LONG).show()
    }
}

class PlayAndPause : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "play and pause", Toast.LENGTH_LONG).show()
    }
}