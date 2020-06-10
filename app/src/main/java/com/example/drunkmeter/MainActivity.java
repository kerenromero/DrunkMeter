package com.example.drunkmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button beginTest;
    private Button pastRes;
    private Button settings;
    private Button info;

    private static final String TAG = "Timer";

    long totalSeconds = 900;
    long intervalSeconds = 1;
    static MyCountDownTimer timer;

    public static ArrayList<PastResEntry> PastResultEntries = new ArrayList<PastResEntry>();
    public static ArrayList<Integer> ratingValues = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beginTest = (Button)findViewById(R.id.beginTest);
        pastRes = (Button)findViewById(R.id.pastRes);
        settings = (Button)findViewById(R.id.settings);
        info = (Button)findViewById(R.id.info);

        timer = new MyCountDownTimer(totalSeconds * 1000, intervalSeconds * 1000);

        beginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                Intent intent = new Intent(MainActivity.this, SignGame.class);
                startActivity(intent);
                Log.d(TAG, "After intent: " + timer.getTime());

            }
        });

        pastRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Past_Res.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Info.class);
                startActivity(intent);
            }
        });
    }

    public class MyCountDownTimer extends CountDownTimer {

        private long time;

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            time = (totalSeconds * 1000 - millisUntilFinished) / 1000;
            Log.d(TAG, "Elapsed: " + (totalSeconds * 1000 - millisUntilFinished) / 1000);
            int progress = (int) (millisUntilFinished/1000);
        }

        @Override
        public void onFinish() {
            finish();
        }

        public long getTime() {
            return time;
        }
    }

}