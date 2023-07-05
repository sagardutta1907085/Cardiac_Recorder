package com.example.cardiacrecorder;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This activity is for splash screen
 */
public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = findViewById(R.id.progressBar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));

        prog();
    }

    private void prog() {

        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                counter+=3;
                progressBar.setProgress(counter);

                if(counter >= 100)
                {
                    timer.cancel();
                    Intent intent = new Intent(SplashActivity.this,LoginPage.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.schedule(task,0,100);
    }

}