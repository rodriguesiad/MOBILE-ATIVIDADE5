package com.example.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

public class NotificationUtils {

    private static final String CHANNEL_ID = "com.exemple.notificatios.android.chanel";
    private static final String CHANNEL_NAME = "My Channel";

    public static String getChannelId(Context context){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = notificationManager.getNotificationChannel(CHANNEL_ID);

        if (channel == null){
            channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        return CHANNEL_ID;
    }

}
