package com.e.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.e.services.service.MyService;

public class MainActivity extends AppCompatActivity {
    Button btnstart, btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();

            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });

    }

    private void stopMyService() {
        stopService(new Intent(this,MyService.class));

    }

    private void startMyService() {
        startService(new Intent(this, MyService.class));
    }
}
