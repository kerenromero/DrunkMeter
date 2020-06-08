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
import java.util.Timer;
import java.util.TimerTask;

public class SignGame extends AppCompatActivity {

    private static final String TAG = "Game";

    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;

    private TextView TextView1;
    private TextView TimerValue;

    private long ResultTime;

    public static ArrayList<PastResEntry> PastResultEntries = Begin_Test.PastResultEntries;
    public ArrayList<Integer>ratingValues = Begin_Test.ratingValues;

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

        Timer myTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                TimerValue.setText(String.valueOf(ResultTime));
                ResultTime++;
            }
        };

        myTimer.scheduleAtFixedRate(task, 1000,1000);

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

        Log.e(TAG, "onCreate: before on click ");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextToPic.get(strSign[randNumString]) == ButtonToRandomImage.get("button1")) {
                    stopTimer(true);
                    TextView1.setText("Its correct");
                } else {
                    stopTimer(false);
                    TextView1.setText("Not correct");

                }
                setEntries();
                callBack();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextToPic.get(strSign[randNumString]) == ButtonToRandomImage.get("button2")){
                    stopTimer(true);
                    TextView1.setText("Its correct");
                }
                else{
                    stopTimer(false);
                    TextView1.setText("Not correct");

                }
                setEntries();
                callBack();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextToPic.get(strSign[randNumString]) == ButtonToRandomImage.get("button3")){
                    stopTimer(true);
                    TextView1.setText("Its correct");
                }
                else{
                    stopTimer(false);
                    TextView1.setText("Not correct");

                }
                setEntries();
                callBack();

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextToPic.get(strSign[randNumString]) == ButtonToRandomImage.get("button4")){
                    stopTimer(true);
                    TextView1.setText("Its correct");
                }
                else{
                    stopTimer(false);
                    TextView1.setText("Not correct");

                }
                setEntries();
                callBack();
            }
        });

    }

    public ArrayList<PastResEntry> getList(){
        return PastResultEntries;
    }

    public void setEntries(){
        PastResEntry newEntry= new PastResEntry();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        Date date = new Date();
        newEntry.setDate(formatter.format(date));

        formatter = new SimpleDateFormat("HH:mm");
        date = new Date();
        newEntry.setTime(formatter.format(date));
        //Still need to do the rating
        newEntry.setRating("69");
        Log.v(TAG, "set entries");
        PastResultEntries.add(newEntry);
        Log.v(TAG, "after set entries");
    }

    public void stopTimer(boolean trueOrfalse){

        if(trueOrfalse == true){
            int finishedGame = (int) ResultTime;
            if(finishedGame < 3 ){
                ratingValues.add(1);
            }
            else if(finishedGame < 4){
                ratingValues.add(2);
            }
            else if(finishedGame < 5){
                ratingValues.add(3);
            }
            else{
                ratingValues.add(4);
            }
        }
        else{
            ratingValues.add(4);

        }

    }

    public void callBack(){
        Intent intent = new Intent(SignGame.this, Begin_Test.class);
        startActivity(intent);
    }
}

