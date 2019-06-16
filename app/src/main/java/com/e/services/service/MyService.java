package com.e.services.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    public Context context = this;
    public Handler handler = null;
    public Runnable runnable = null;

    public MyService(){}

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        Toast.makeText(this, "service created", Toast.LENGTH_LONG).show();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                double randomNo = getRandomDoubleBetweenRange(1,100);
                Toast.makeText(context,"randon number" + randomNo ,Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable,2000);
            }
        };
        handler.postDelayed(runnable,2000);
    }

    private double getRandomDoubleBetweenRange(double min, double max) {
        return (Math.random()*((max - min)+1)) +min;
    }
    @Override
    public void onDestroy(){
        handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service Stoped",Toast.LENGTH_LONG).show();

    }


}
