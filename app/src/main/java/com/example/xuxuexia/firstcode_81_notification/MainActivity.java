package com.example.xuxuexia.firstcode_81_notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.File;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button buttonTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTest = (Button) findViewById(R.id.send_notice);
        buttonTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_notice:
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Uri soundUri = Uri.fromFile(new File("/system/media/audio/ringtones/Basic_tone.ogg"));
                long[] vibrates={0,1000,1000,1000};
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                Notification notification = new Notification.Builder(this)
                        .setTicker("This is ticker")
                        .setContentTitle("Content title")
                        .setContentText("Content text")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setSound(soundUri)
                        .setVibrate(vibrates)
                        .setLights(Color.GREEN,1000,1000)
                        .build();
                manager.notify(1,notification);

                break;
            default:
                break;
        }


    }
}
