package com.example.drunkmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ColorGame extends AppCompatActivity {

    private static final String TAG = "Color Game";

    private ImageButton button5;
    private ImageButton button6;
    private ImageButton button7;
    private ImageButton button8;
    private TextView TextView2;
    public static TextView TimerValue;


    private long ResultTime;

    long timeAtStart;
    int [] picColor = {R.drawable.red, R.drawable.blue, R.drawable.green, R.drawable.orange};
    String [] picColorStr = {"R.drawable.red", "R.drawable.blue", "R.drawable.green", "R.drawable.orange"};
    String [] strColor = {"Click on the Red button", "Click on the Blue button", "Click on the Orange button", "Click on the Green button"};
    int [] seeColor = {Color.RED, Color.BLUE, Color.GREEN, Color.parseColor("#FFA500")};

    Map<String, String> TextToPic = new HashMap<String, String>();
    Map<String, String> ButtonToRandomImage = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_game);

        MainActivity.timer.setViewableTime("ColorGame");
        timeAtStart = MainActivity.timer.getTime();
        button5 = (ImageButton)findViewById(R.id.imageButton5);
        button6 = (ImageButton)findViewById(R.id.imageButton6);
        button7 = (ImageButton)findViewById(R.id.imageButton7);
        button8 = (ImageButton)findViewById(R.id.imageButton8);
        TextView2 = (TextView)findViewById(R.id.textView2);

        TimerValue = (TextView)findViewById(R.id.timer1);


        TextToPic.put("Click on the Red button", "R.drawable.red");
        TextToPic.put("Click on the Blue button", "R.drawable.blue");
        TextToPic.put("Click on the Orange button", "R.drawable.orange");
        TextToPic.put("Click on the Green button", "R.drawable.green");

        final int randNumString = mapButtonToImage();

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+ MainActivity.timer.getTime());
                ResultTime = MainActivity.timer.getTime();
                if (TextToPic.get(strColor[randNumString]) == ButtonToRandomImage.get("button5")) {
                    stopTimer(true);
                    TextView2.setText("Correct");
                } else {
                    stopTimer(false);
                    TextView2.setText("Not correct");

                }
                callBack();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+ MainActivity.timer.getTime());
                ResultTime = MainActivity.timer.getTime();
                if (TextToPic.get(strColor[randNumString]) == ButtonToRandomImage.get("button6")) {
                    stopTimer(true);
                    TextView2.setText("Correct");
                } else {
                    stopTimer(false);
                    TextView2.setText("Not correct");

                }
                callBack();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+ MainActivity.timer.getTime());
                ResultTime = MainActivity.timer.getTime();
                if (TextToPic.get(strColor[randNumString]) == ButtonToRandomImage.get("button7")) {
                    stopTimer(true);
                    TextView2.setText("Correct");
                } else {
                    stopTimer(false);
                    TextView2.setText("Not correct");

                }
                callBack();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+ MainActivity.timer.getTime());
                ResultTime = MainActivity.timer.getTime();
                if (TextToPic.get(strColor[randNumString]) == ButtonToRandomImage.get("button8")) {
                    stopTimer(true);
                    TextView2.setText("Its correct");
                } else {
                    stopTimer(false);
                    TextView2.setText("Not correct");

                }
                callBack();
            }
        });


    }

    public int mapButtonToImage(){

        Random rand = new Random();
        int len = picColor.length;
        final int randNumString = rand.nextInt(strColor.length);

        TextView2.setText(strColor[randNumString]);
        int randColorString = rand.nextInt(strColor.length);
        TextView2.setTextColor(seeColor[randColorString]);

        for(int i = 0; i < picColor.length; i++){
            int randNum = rand.nextInt(len);
            int randomImage = picColor[randNum];
            if(i == 0) {
                button5.setImageResource(randomImage);
                ButtonToRandomImage.put("button5", picColorStr[randNum]);
            }
            if(i == 1) {
                button6.setImageResource(randomImage);
                ButtonToRandomImage.put("button6", picColorStr[randNum]);
            }
            if(i == 2) {
                button7.setImageResource(randomImage);
                ButtonToRandomImage.put("button7", picColorStr[randNum]);
            }
            if(i == 3) {
                button8.setImageResource(randomImage);
                ButtonToRandomImage.put("button8", picColorStr[randNum]);
            }

            int temp = picColor[randNum];
            picColor[randNum] = picColor[len-1];
            picColor[len-1] = temp;

            String temp2 = picColorStr[randNum];
            picColorStr[randNum] = picColorStr[len-1];
            picColorStr[len-1] = temp2;
            len--;
        }
        return randNumString;
    }

    public void stopTimer(boolean trueOrfalse){

        if(trueOrfalse == true){
            int finishedGame = (int) ResultTime - (int) timeAtStart;
            if(finishedGame <= 2){
                MainActivity.ratingValues.add(0);
            }
            else if(finishedGame <= 4){
                MainActivity.ratingValues.add(1);
            }
            else if(finishedGame <= 6){
                MainActivity.ratingValues.add(2);
            }
            else{
                MainActivity.ratingValues.add(3);
            }
        }
        else{
            MainActivity.ratingValues.add(3);

        }

    }

    public void callBack(){
        Intent intent = new Intent(ColorGame.this, AlphabetGame.class);
        startActivity(intent);
    }



}