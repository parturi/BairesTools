package com.bairesweb.pcheck;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class PowerChecker extends Service{

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public void onDestroy(){

        super.onDestroy();
        Toast.makeText(this, "Se terminó el servicio " + getString(R.string.app_name), Toast.LENGTH_LONG).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        PowerBroadcastReceiver receiver = new PowerBroadcastReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, filter);
        Log.i("PowerChecker", "Received start id " + startId + ": " + intent);
        Toast.makeText(this, "Se inicio el servicio " + getString(R.string.app_name), Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

}
