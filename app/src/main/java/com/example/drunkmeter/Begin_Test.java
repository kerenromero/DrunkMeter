package com.example.drunkmeter;


import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Begin_Test extends AppCompatActivity {

    private static final String TAG = "BeginTest";
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private TextView TextView1;

    int [] picSign = {R.drawable.div, R.drawable.mult, R.drawable.plus, R.drawable.sub};
    String [] strSign = {"Click on the Division sign", "Click on the Multiplication sign", "Click on the Addition sign", "Click on the Subtraction sign" };

    Map<String, String> TextToPic = new HashMap<String, String>();
    Map<String, String> ButtonToRandomImage = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin__test);


        TextToPic.put("Click on the Division sign", "R.drawable.div");
        TextToPic.put("Click on the Multiplication sign", "R.drawable.mult");
        TextToPic.put("Click on the Addition sign", "R.drawable.plus");
        TextToPic.put("Click on the Subtraction sign", "R.drawable.sub");


        button1 = (ImageButton)findViewById(R.id.imageButton);
        button2 = (ImageButton)findViewById(R.id.imageButton2);
        button3 = (ImageButton)findViewById(R.id.imageButton3);
        button4 = (ImageButton)findViewById(R.id.imageButton4);
        TextView1 = (TextView)findViewById(R.id.textView);

        Random rand = new Random();
        int len = picSign.length;
        final int randNumString = rand.nextInt(strSign.length);
        TextView1.setText(strSign[randNumString]);

        for(int i = 0; i < picSign.length; i++){
            int randNum = rand.nextInt(len);
            int randomImage = picSign[randNum];
            Log.e(TAG, "onCreate: " + randomImage);
            if(i == 0) {
                button1.setImageResource(randomImage);
                //ButtonToRandomImage.put("button1", randomImage.)
            }
            if(i == 1)
                button2.setImageResource(randomImage);
            if(i == 2)
                button3.setImageResource(randomImage);
            if(i == 3)
                button4.setImageResource(randomImage);
            int temp = picSign[randNum];
            picSign[randNum] = picSign[len-1];
            picSign[len-1] = temp;
            len--;
        }


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(TextToPic.get(strSign[randNumString]) == button1..toString()){
//                    TextView1.setText("Its correct");
//                }
//                else{
//                    TextView1.setText(button1.getDrawable().toString());
//                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextToPic.get(strSign[randNumString]) == button2.getDrawable().toString()){
                    TextView1.setText("Its correct");
                }
                else{
                    TextView1.setText(button2.getDrawable().toString());
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextToPic.get(strSign[randNumString]) == button3.getDrawable().toString()){
                    TextView1.setText("Its correct");
                }
                else{
                    TextView1.setText(button3.getDrawable().toString());
                }

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextToPic.get(strSign[randNumString]) == button4.getDrawable().toString()){
                    TextView1.setText("Its correct");
                }
                else{
                    TextView1.setText(button4.getDrawable().toString());
                }

            }
        });

    }
}

