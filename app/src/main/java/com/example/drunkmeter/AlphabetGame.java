package com.example.drunkmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class AlphabetGame extends AppCompatActivity {

    private static final String TAG = "Alph game";
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    private TextView TextView4;
    public static TextView TimerValue;


    int max = 23;
    int min = 2;
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int randChar = (int)(Math.random() * (max - min + 1) + min);
    String [] beforeOrAfter = {"Click on the button that comes before", "Click on the button that comes after"};
    final int randBorA = (int)(Math.random() * (1 - 0 + 1) + 0);
    int [] alphabetOptions = {randChar+1,randChar+2,randChar-1,randChar-2};

    private long ResultTime;
    long timeAtStart;

    Map<String, Character> buttonToChar = new HashMap<String, Character>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_game);

        MainActivity.timer.setViewableTime("AlphabetGame");

        timeAtStart = MainActivity.timer.getTime();
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        TextView4 = (TextView)findViewById(R.id.textView4);

        TimerValue = (TextView)findViewById(R.id.timer2);


        gameImplementation();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultTime = MainActivity.timer.getTime();
                if(randBorA == 0){
                    if(buttonToChar.get("button1") == alphabet.charAt(randChar-1)){
                        TextView4.setText("Correct");
                        stopTimer(true);
                    }
                    else{
                        TextView4.setText("Not Correct");
                        stopTimer(false);
                    }
                }
                else{
                    if(buttonToChar.get("button1") == alphabet.charAt(randChar+1)){
                        TextView4.setText("Correct");
                        stopTimer(true);
                    }
                    else{
                        TextView4.setText("Not Correct");
                        stopTimer(false);
                    }
                }
                setEntries();
                callBack();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultTime = MainActivity.timer.getTime();
                if(randBorA == 0){
                    if(buttonToChar.get("button2") == alphabet.charAt(randChar-1)){
                        TextView4.setText("Correct");
                        stopTimer(true);
                    }
                    else{
                        TextView4.setText("Not Correct");
                        stopTimer(false);
                    }
                }
                else{
                    if(buttonToChar.get("button2") == alphabet.charAt(randChar+1)){
                        TextView4.setText("Correct");
                        stopTimer(true);
                    }
                    else{
                        TextView4.setText("Not Correct");
                        stopTimer(false);
                    }

                }
                setEntries();
                callBack();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultTime = MainActivity.timer.getTime();
                if(randBorA == 0){
                    if(buttonToChar.get("button3") == alphabet.charAt(randChar-1)){
                        TextView4.setText("Correct");
                        stopTimer(true);
                    }
                    else{
                        TextView4.setText("Not Correct");
                        stopTimer(false);
                    }
                }
                else{
                    if(buttonToChar.get("button3") == alphabet.charAt(randChar+1)){
                        TextView4.setText("Correct");
                        stopTimer(true);
                    }
                    else{
                        TextView4.setText("Not Correct");
                        stopTimer(false);
                    }
                }
                setEntries();
                callBack();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultTime = MainActivity.timer.getTime();
                if(randBorA == 0){
                    if(buttonToChar.get("button4") == alphabet.charAt(randChar-1)){
                        TextView4.setText("Correct");
                        stopTimer(true);
                    }
                    else{
                        TextView4.setText("Not Correct");
                        stopTimer(false);
                    }
                }
                else{
                    if(buttonToChar.get("button4") == alphabet.charAt(randChar+1)){
                        TextView4.setText("Correct");
                        stopTimer(true);
                    }
                    else{
                        TextView4.setText("Not Correct");
                        stopTimer(false);
                    }
                }
                setEntries();
                callBack();
            }
        });

    }

    public void gameImplementation(){

        TextView4.setText(beforeOrAfter[randBorA] + " " + String.valueOf(alphabet.charAt(randChar)));

        int len = alphabetOptions.length;
        Random rand = new Random();

        for(int i = 0; i < alphabetOptions.length; i++){
            int randNum = rand.nextInt(len);
            String assignButtons = String.valueOf(alphabet.charAt(alphabetOptions[randNum]));
            if(i == 0) {
                button1.setText(assignButtons);
                buttonToChar.put("button1", alphabet.charAt(alphabetOptions[randNum]));
            }
            if(i == 1) {
                button2.setText(assignButtons);
                buttonToChar.put("button2", alphabet.charAt(alphabetOptions[randNum]));
            }
            if(i == 2) {
                button3.setText(assignButtons);
                buttonToChar.put("button3", alphabet.charAt(alphabetOptions[randNum]));
            }
            if(i == 3) {
                button4.setText(assignButtons);
                buttonToChar.put("button4", alphabet.charAt(alphabetOptions[randNum]));
            }

            int temp = alphabetOptions[randNum];
            alphabetOptions[randNum] = alphabetOptions[len-1];
            alphabetOptions[len-1] = temp;
            len--;
        }

    }

    public void stopTimer(boolean trueOrfalse){

        if(trueOrfalse == true){
            int finishedGame = (int) ResultTime - (int) timeAtStart;
            if(finishedGame < 8){
                MainActivity.ratingValues.add(0);
            }
            else if(finishedGame < 9){
                MainActivity.ratingValues.add(1);
            }
            else if(finishedGame < 10){
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
        Intent intent = new Intent(AlphabetGame.this, ResultPage.class);
        startActivity(intent);
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(MainActivity.PastResultEntries);
        editor.putString("Past Entries List", json);
        editor.apply();
    }

    public void setEntries(){
        PastResEntry newEntry= new PastResEntry();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
        Date date = new Date();
        newEntry.setDate(formatter.format(date));

        formatter = new SimpleDateFormat("HH:mm");
        date = new Date();
        newEntry.setTime(formatter.format(date));

        int averageRating = (MainActivity.ratingValues.get(0) + MainActivity.ratingValues.get(1) + MainActivity.ratingValues.get(2));
        if(averageRating < 3){
            newEntry.setRating("Night just started");
        }
        else if(averageRating < 5){
            newEntry.setRating("Vibing");
        }
        else if(averageRating < 7){
            newEntry.setRating("Big Chilling");
        }
        else if(averageRating < 9){
            newEntry.setRating("Should I text my ex");
        }
        else{
            newEntry.setRating("Shit Faced");
        }

        Log.v(TAG, "set entries");
        MainActivity.PastResultEntries.add(newEntry);
        saveData();
        Log.v(TAG, "after set entries");
    }
}