package com.geosparksdk.androidexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(2 * 1000);
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        background.start();
    }
}



