package com.example.ch05_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
          Toast.makeText(context, "收到一个广播-->"+intent.getStringExtra("info"), Toast.LENGTH_SHORT).show();
    }
}