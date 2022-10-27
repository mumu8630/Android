package com.example.ch05_broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button staticB ,dynamicB,orderB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        静态广播
        staticB = findViewById(R.id.staticButton);
        staticB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StaticActivity.class);
                startActivity(intent);
                finish();
            }
        });


//        动态广播
        dynamicB = findViewById(R.id.dynamicButton);
        dynamicB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DynamicActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        有序广播
        orderB = findViewById(R.id.orderButton);
        orderB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }


}