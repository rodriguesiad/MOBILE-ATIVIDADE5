package com.example.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())){
            notify(context, true);
        }
        else if(Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())) {
            notify(context, false);
        }
    }

    private void notify(Context context, boolean isConnected){
        String title = "Mudança no estado...";
        String text = isConnected ? "O dispositivo foi conectado à força externa." : "O dispositivo foi desconectado da força externa.";

        Intent intent = new Intent(context, Main2Activity.class);
        intent.putExtra("isConnected", isConnected);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);


        Notification.Builder builder = new Notification.Builder(context, NotificationUtils.getChannelId(context))
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(android.R.drawable.sym_action_chat)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(40, builder.build());
    }

}