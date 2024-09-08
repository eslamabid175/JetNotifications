package com.eslam.jetnotifications

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

fun actionNotifications(context: Context) {

    val intent = Intent(context,ReplyReceiver::class.java)

    val pendingIntent = PendingIntent.getBroadcast(
        context, 3,intent,PendingIntent.FLAG_IMMUTABLE
    )

    val notification = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("title")
        .setContentText("desc")
        .addAction(R.drawable.ic_reply_24, "reply",pendingIntent)
        .build()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(8,notification)
        }
    }else{
        NotificationManagerCompat.from(context).notify(8,notification)
    }

}

class ReplyReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "reply", Toast.LENGTH_LONG).show()
    }
}