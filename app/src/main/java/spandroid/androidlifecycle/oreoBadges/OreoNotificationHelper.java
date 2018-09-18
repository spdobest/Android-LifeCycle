package spandroid.androidlifecycle.oreoBadges;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.SyncStateContract;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationManagerCompat;

import java.util.ArrayList;
import java.util.List;

import spandroid.androidlifecycle.R;
import spandroid.androidlifecycle.observerPattern.ObserverActivity;

public class OreoNotificationHelper {

    private static final String TAG = "OreoNotificationHelper";

    Context mContext;
    private NotificationManager notifManager;

    public static String CITIES_CHANEL_ID = "city";
    public static String APP_CHANEL_ID = "MyApp";


    public OreoNotificationHelper(Context mContext) {
        this.mContext = mContext;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private NotificationChannel createAppNotificationChanel(final String chanelId,
                                                            final String chanelName,
                                                            final String chanelDescription,
                                                            final int chanelImportance) {
        NotificationChannel channel = new NotificationChannel(chanelId, chanelName, chanelImportance);
        channel.setDescription(chanelDescription);
        return channel;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createNotificationChannels() {
        final List<NotificationChannel> channels = new ArrayList<>();
        channels.add(createAppNotificationChanel(
                CITIES_CHANEL_ID,
                "Cities",
                "Information about cities",
                NotificationManagerCompat.IMPORTANCE_HIGH));
        channels.add(createAppNotificationChanel(
                APP_CHANEL_ID,
                "Application",
                "General app updates",
                NotificationManagerCompat.IMPORTANCE_DEFAULT));
        final NotificationManager notificationManager = (NotificationManager)
                mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.createNotificationChannels(channels);
        }
    }

    public void postOreoNotification(Context context,int id,String name,String message) {

        Notification.Builder notificationBuilder = getNotification1(context,name,
               message);

        if (notificationBuilder != null) {

            Intent intent = new Intent(context.getApplicationContext(), ObserverActivity.class);
             PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);


            notificationBuilder.setContentIntent(pendingIntent);

            notify(id, notificationBuilder);
        }
    }

    public Notification.Builder getNotification1(Context context,String title, String body) {
        return new Notification.Builder(context, CITIES_CHANEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true);
    }
    public void notify(int id, Notification.Builder notification) {
        getManager().notify(id, notification.build());
    }
    private NotificationManager getManager() {
        if (notifManager == null) {
            notifManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notifManager;
    }

}
