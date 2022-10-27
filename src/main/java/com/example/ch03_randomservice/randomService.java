package com.example.ch03_randomservice;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class randomService extends Service {

    private Thread workThread;

    public randomService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("randomService","randomService------onCreate");
        //线程组，需要执行的Runnable对象，线程的名称
        workThread = new Thread(null,backgroundWork,"WorkThread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("randomService", "randomService------onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (!workThread.isAlive()){
                    workThread.start();
                    }
                }
        }).start();

        //不自动重建
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        workThread.interrupt();
        Log.v("randomService","randomService------on destroy");
    }

    private Runnable backgroundWork = new Runnable() {
        @Override
        public void run() {
            try {
                while(!Thread.interrupted()){
                    double random = Math.random()*100;
                    System.out.println(random);
                    main.UpdateCount(random);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}


