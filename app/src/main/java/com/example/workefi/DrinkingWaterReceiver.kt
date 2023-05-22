package com.example.workefi

import android.Manifest
import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class DrinkingWaterReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {


        val requestCode = 1111
        val notificationId = 11111
        val i = Intent (context, MainActivity::class.java)
        //intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        //val pendingIntent = PendingIntent.getActivity (context, 1111,i, PendingIntent.FLAG_IMMUTABLE)
        val notificationManager = context?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var vibrationPattern = longArrayOf(0, 1000, 500, 1000)
            val attributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build()
            val channel = NotificationChannel("workEfi", "DrinkingWater",NotificationManager.IMPORTANCE_HIGH).apply {
                enableVibration(true)
                vibrationPattern = vibrationPattern
            }
            notificationManager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(context, "workEfi")
            .setSmallIcon(R.drawable.workefi_logo)
            .setContentTitle("WorkEfi")
            .setContentText("Time to get Hydrated")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setDefaults(Notification.DEFAULT_VIBRATE)
            .setAutoCancel(true)

        //val notificationManager = NotificationManagerCompat.from(context)
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

            val mediaPlayer = MediaPlayer.create(context, R.raw.drinkingwater_tone1)
            mediaPlayer.start()
            notificationManager.notify(notificationId, builder.build())

    }
}
