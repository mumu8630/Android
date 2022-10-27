package com.example.ch05_broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaticActivity extends AppCompatActivity {
    private Button staticB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);

       staticB = findViewById(R.id.staticButton);
       staticB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               intent.setComponent(new ComponentName(StaticActivity.this,"com.example.ch05_broadcast.MyReceiver"));
               intent.putExtra("info","静态广播");
               sendBroadcast(intent);
           }
       });
    }
}