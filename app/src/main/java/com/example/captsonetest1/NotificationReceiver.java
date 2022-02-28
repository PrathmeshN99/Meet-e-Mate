package com.example.captsonetest1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.os.IResultReceiver;

import androidx.core.app.NotificationCompat;

public class NotificationReceiver extends BroadcastReceiver {

    private String content;
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context,RepeatingActivity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Prathmesh")
                .setSmallIcon(android.R.drawable.star_on)
                .setContentTitle("L12")
                .setContentText("Capstone")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationManager.notify(100,builder.build());
    }
}