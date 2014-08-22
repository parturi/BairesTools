package com.bairesweb.pcheck;


import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class PowerBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context ctx, Intent intent){

        int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);

        String USBStatus;

        if (plugged == BatteryManager.BATTERY_PLUGGED_AC || plugged == BatteryManager.BATTERY_PLUGGED_USB) {
            USBStatus = "USB Conectado!!";
        } else {
            USBStatus = "USB Desconectado!";
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentText(USBStatus)
                .setContentTitle("Attention");
        NotificationManager manager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

        Log.i("PowerChecker", "Received in start id " + "intent:  " + intent);

    }
}
