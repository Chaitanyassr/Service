package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class myservice extends Service {
    MediaPlayer player;
   public myservice() {
  }

    public IBinder onBind(Intent intent){return null;}

    public void onCreate(){
        super.onCreate();
        Toast.makeText(this, "In onCreate{}", Toast.LENGTH_LONG).show();
        player= MediaPlayer.create(this,R.raw.abcd);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "In onStart()", Toast.LENGTH_LONG).show();
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "In onDestroy()", Toast.LENGTH_LONG).show();
        player.stop();
    }
}
