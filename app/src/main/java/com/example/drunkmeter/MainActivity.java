package com.example.drunkmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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

    public static ArrayList<PastResEntry> PastResultEntries;
    public static ArrayList<Integer> ratingValues = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        beginTest = (Button)findViewById(R.id.beginTest);
        pastRes = (Button)findViewById(R.id.pastRes);
        settings = (Button)findViewById(R.id.settings);
        info = (Button)findViewById(R.id.info);

        timer = new MyCountDownTimer(totalSeconds * 1000, intervalSeconds * 1000);

        beginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        private String activityName;

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            time = (totalSeconds * 1000 - millisUntilFinished) / 1000;
            Log.d(TAG, "Elapsed: " + (totalSeconds * 1000 - millisUntilFinished) / 1000);
            int progress = (int) (millisUntilFinished/1000);

            if(activityName == "SignGame"){
                SignGame.TimerValue.setText(String.valueOf((int) ((totalSeconds * 1000 - millisUntilFinished) / 1000)));
            }
            if(activityName == "ColorGame"){
                ColorGame.TimerValue.setText(String.valueOf((int) ((totalSeconds * 1000 - millisUntilFinished) / 1000)));

            }
            if(activityName == "AlphabetGame"){
                AlphabetGame.TimerValue.setText(String.valueOf((int) ((totalSeconds * 1000 - millisUntilFinished) / 1000)));
            }
        }

        @Override
        public void onFinish() {
            finish();
        }

        public long getTime() {
            return time;
        }

        public void setViewableTime(String activityName){
            this.activityName = activityName;
        }

    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Past Entries List", null);
        Type type = new TypeToken<ArrayList<PastResEntry>>() {}.getType();
        PastResultEntries = gson.fromJson(json, type);
        if(PastResultEntries == null){
            PastResultEntries = new ArrayList<PastResEntry>();
        }
    }



}