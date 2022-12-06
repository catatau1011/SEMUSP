package com.example.semusp.informativo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.semusp.R;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage Notificacao) {
        if (Notificacao.getNotification()!= null);
        String titulo = Notificacao.getNotification().getTitle();
        String corpo = Notificacao.getNotification().getBody();
        enviarNotificacao(titulo, corpo);

        Log.i("Notificacao", "recebida titulo" + titulo + "corpo" + corpo);
    }
    private void enviarNotificacao(String titulo, String corpo) {
        String canal = getString(R.string.default_notification_channel_id);
        Uri Urisom = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intent = new Intent(this, InfromativoActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificacao = new NotificationCompat.Builder(this, canal)
                .setContentTitle( titulo )
                .setContentText( corpo )
                .setSmallIcon(R.drawable.ic_camera)
                .setSound( Urisom)
                .setAutoCancel(true )
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager  = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // Verificar versão do Android a partrir do 8.0 para configurar um canal de notificação
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(canal, "Canal de Not", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }


        notificationManager.notify(0, notificacao.build());
    }


    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }
}
