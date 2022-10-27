package com.example.ch05_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    private static final String action = "myOrder";
    private Button orderB;
    MyReceiverOne one;
    MyReceiverTwo two;
    MyReceiverThree three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        registerReceiver();

        orderB = findViewById(R.id.orderButton);
        orderB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(action);
//                intent 和 权限两个参数
                sendOrderedBroadcast(intent,null);
            }
        });
    }
    //        注册广播 --- 有序广播需要动态注册
    public void registerReceiver(){
        one = new MyReceiverOne();
        IntentFilter filter1 = new IntentFilter();
//        设置优先级 -1000~1000
        filter1.setPriority(1000);
        filter1.addAction(action);
        registerReceiver(one,filter1);

        two = new MyReceiverTwo();
        IntentFilter filter2 = new IntentFilter();
        filter2.setPriority(500);
        filter2.addAction(action);
        registerReceiver(two,filter2);

        three = new MyReceiverThree();
        IntentFilter filter3 = new IntentFilter();
        filter3.setPriority(900);
        filter3.addAction(action);
        registerReceiver(three,filter3);


    }
}
class MyReceiverOne extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "第一个广播执行.....", Toast.LENGTH_SHORT).show();
    }
}
class MyReceiverTwo extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "第二个广播执行.....", Toast.LENGTH_SHORT).show();
    }
}
class MyReceiverThree extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "第三个广播执行.....", Toast.LENGTH_SHORT).show();
    }
}