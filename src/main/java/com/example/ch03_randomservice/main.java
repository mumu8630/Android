package com.example.ch03_randomservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class main extends AppCompatActivity {

    private static double randomNUm;
    private static TextView num;
    private Button start ,stop;


    //先在主线程中创建Handler，Handler会自动与主线程绑定
    private  static Handler handler = new Handler();

    //    创建新线程
    public static Runnable runnable = new Runnable() {
        @Override
        public void run() {
              num.setText(String.valueOf(randomNUm));
        }
    };


    public static void UpdateCount(double refreshDouble){
        randomNUm = refreshDouble;
        handler.post(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num =(TextView)findViewById(R.id.count);
        start = (Button) findViewById(R.id.button1);
        stop = (Button)findViewById(R.id.button2);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(main.this,randomService.class));
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(main.this, randomService.class));
            }
        });


    }
}