package com.example.drunkmeter;


import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Begin_Test extends AppCompatActivity {

    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private TextView TextView1;

    int [] picSign = {R.drawable.div, R.drawable.mult, R.drawable.plus, R.drawable.sub};
    String [] strSign = {"Click on the Division sign", "Click on the Multiplication sign", "Click on the Addition sign", "Click on the Subtraction sign" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin__test);

        button1 = (ImageButton)findViewById(R.id.imageButton);
        button2 = (ImageButton)findViewById(R.id.imageButton2);
        button3 = (ImageButton)findViewById(R.id.imageButton3);
        button4 = (ImageButton)findViewById(R.id.imageButton4);
        TextView1 = (TextView)findViewById(R.id.textView);

        Random rand = new Random();
        int len = picSign.length;
        int randNumString = rand.nextInt(strSign.length);
        TextView1.setText(strSign[randNumString]);

        for(int i = 0; i < picSign.length; i++){
            int randNum = rand.nextInt(len);
            int randomImage = picSign[randNum];
            if(i == 0)
                button1.setImageResource(randomImage);
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

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public int getArrayIndex(int[] arr, int value) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
        return k;
    }

    public int getArrayIndex(String[] arr, String value) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
        return k;
    }
}

