package com.example.ch05_broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicActivity extends AppCompatActivity {
    private Button dynamicB, registerB,unregisterB;
    private MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        dynamicB =findViewById(R.id.dynamicButton);
        dynamicB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("myDynamicReceiver");
                intent.putExtra("info","动态广播");
                sendBroadcast(intent);
            }
        });

        registerB = findViewById(R.id.registerButton);
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myReceiver = new MyReceiver();
                IntentFilter filter = new IntentFilter();
                filter.addAction("myDynamicReceiver");
                registerReceiver(myReceiver,filter);
            }
        });

        unregisterB=findViewById(R.id.unregisterButton);
        unregisterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unregisterReceiver(myReceiver);
            }
        });

    }
}