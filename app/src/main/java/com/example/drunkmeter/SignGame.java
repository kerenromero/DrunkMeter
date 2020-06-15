package com.example.drunkmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class SignGame extends AppCompatActivity {

    private static final String TAG = "Sign Game";

    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;

    private TextView TextView1;
    private TextView TimerValue;

    private long ResultTime;

   // static MainActivity.MyCountDownTimer timer = MainActivity.timer;

    // public ArrayList<Integer>ratingValues = MainActivity.ratingValues;

    int [] picSign = {R.drawable.div, R.drawable.mult, R.drawable.plus, R.drawable.sub};
    String [] picSignStr = {"R.drawable.div", "R.drawable.mult", "R.drawable.plus", "R.drawable.sub"};
    String [] strSign = {"Click on the Division sign", "Click on the Multiplication sign", "Click on the Addition sign", "Click on the Subtraction sign" };
    Map<String, String> TextToPic = new HashMap<String, String>();
    Map<String, String> ButtonToRandomImage = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_game);

        Log.e(TAG, "onCreate: after on create ");

        TimerValue = (TextView)findViewById(R.id.timer);

        button1 = (ImageButton)findViewById(R.id.imageButton);
        button2 = (ImageButton)findViewById(R.id.imageButton2);
        button3 = (ImageButton)findViewById(R.id.imageButton3);
        button4 = (ImageButton)findViewById(R.id.imageButton4);
        TextView1 = (TextView)findViewById(R.id.textView);

        TextToPic.put("Click on the Division sign", "R.drawable.div");
        TextToPic.put("Click on the Multiplication sign", "R.drawable.mult");
        TextToPic.put("Click on the Addition sign", "R.drawable.plus");
        TextToPic.put("Click on the Subtraction sign", "R.drawable.sub");

        final int randNumString = mapButtonToImage();

        Log.e(TAG, "onCreate: before on click ");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+ MainActivity.timer.getTime());
                ResultTime = MainActivity.timer.getTime();
                if (TextToPic.get(strSign[randNumString]) == ButtonToRandomImage.get("button1")) {
                    stopTimer(true);
                    TextView1.setText("Its correct");
                } else {
                    stopTimer(false);
                    TextView1.setText("Not correct");

                }
                callBack();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+ MainActivity.timer.getTime());
                ResultTime = MainActivity.timer.getTime();
                if(TextToPic.get(strSign[randNumString]) == ButtonToRandomImage.get("button2")){
                    stopTimer(true);
                    TextView1.setText("Its correct");
                }
                else{
                    stopTimer(false);
                    TextView1.setText("Not correct");

                }
                callBack();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+ MainActivity.timer.getTime());
                ResultTime = MainActivity.timer.getTime();
                if(TextToPic.get(strSign[randNumString]) == ButtonToRandomImage.get("button3")){
                    stopTimer(true);
                    TextView1.setText("Its correct");
                }
                else{
                    stopTimer(false);
                    TextView1.setText("Not correct");

                }
                callBack();

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+ MainActivity.timer.getTime());
                ResultTime = MainActivity.timer.getTime();
                if(TextToPic.get(strSign[randNumString]) == ButtonToRandomImage.get("button4")){
                    stopTimer(true);
                    TextView1.setText("Its correct");
                }
                else{
                    stopTimer(false);
                    TextView1.setText("Not correct");

                }
                callBack();
            }
        });

    }

    public void stopTimer(boolean trueOrfalse){

        if(trueOrfalse == true){
            int finishedGame = (int) ResultTime;
            if(finishedGame < 3 ){
                MainActivity.ratingValues.add(1);
            }
            else if(finishedGame < 4){
                MainActivity.ratingValues.add(2);
            }
            else if(finishedGame < 5){
                MainActivity.ratingValues.add(3);
            }
            else{
                MainActivity.ratingValues.add(4);
            }
        }
        else{
            MainActivity.ratingValues.add(4);

        }

    }

    public void callBack(){
        Intent intent = new Intent(SignGame.this, ColorGame.class);
        startActivity(intent);
    }

    public int mapButtonToImage(){

        Random rand = new Random();
        int len = picSign.length;
        final int randNumString = rand.nextInt(strSign.length);
        TextView1.setText(strSign[randNumString]);

        for(int i = 0; i < picSign.length; i++){
            int randNum = rand.nextInt(len);
            int randomImage = picSign[randNum];
            if(i == 0) {
                button1.setImageResource(randomImage);
                ButtonToRandomImage.put("button1", picSignStr[randNum]);
            }
            if(i == 1) {
                button2.setImageResource(randomImage);
                ButtonToRandomImage.put("button2", picSignStr[randNum]);
            }
            if(i == 2) {
                button3.setImageResource(randomImage);
                ButtonToRandomImage.put("button3", picSignStr[randNum]);
            }
            if(i == 3) {
                button4.setImageResource(randomImage);
                ButtonToRandomImage.put("button4", picSignStr[randNum]);
            }

            int temp = picSign[randNum];
            picSign[randNum] = picSign[len-1];
            picSign[len-1] = temp;

            String temp2 = picSignStr[randNum];
            picSignStr[randNum] = picSignStr[len-1];
            picSignStr[len-1] = temp2;
            len--;
        }
        return randNumString;
    }
}

