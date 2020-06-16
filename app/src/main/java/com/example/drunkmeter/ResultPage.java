package com.example.drunkmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextClock;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView3;
    private RatingBar ratingBar;
    private Button playAgain;
    private Button returnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        imageView = (ImageView)findViewById(R.id.imageView);
        textView3 = (TextView)findViewById(R.id.textView3);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        playAgain = (Button)findViewById(R.id.playAgain);
        returnHome = (Button)findViewById(R.id.returnHome);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultPage.this, SignGame.class);
                startActivity(intent);
            }
        });

        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        textView3.setText(MainActivity.PastResultEntries.get(MainActivity.PastResultEntries.size()-1).getRating());

    }


}