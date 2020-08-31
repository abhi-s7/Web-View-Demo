package com.abhi.webviewdemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.abhi.webviewdemo.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "Notification";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotificatin(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());

        Log.d(TAG, "onMessageReceived: " + remoteMessage.getNotification().getBody());
    }

    public void showNotificatin(String title, String message){
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"wets");

        builder.setContentTitle(title)
//                .setSmallIcon(R.mipmap.icon_background)
                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.mipmap.ic_launcher_round))
                .setSound(soundUri)
                .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)
                .setContentIntent(pi)
                .setContentText(message);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


            /**********Your background color and icon**************/
            builder.setSmallIcon(R.drawable.ic_launcher_background);
            builder.setColor(getResources().getColor(R.color.navi_background));
            /*******************************************************/


        } else {
            builder.setSmallIcon(R.mipmap.ic_launcher_round);
        }



        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());
    }


}
