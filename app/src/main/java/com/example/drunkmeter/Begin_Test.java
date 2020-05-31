package com.example.drunkmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import java.util.Random;

public class Begin_Test extends AppCompatActivity {

    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;

    int [] picSign = {R.drawable.div, R.drawable.mult, R.drawable.plus, R.drawable.sub};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin__test);

        button1 = (ImageButton)findViewById(R.id.imageButton);
        button2 = (ImageButton)findViewById(R.id.imageButton2);
        button3 = (ImageButton)findViewById(R.id.imageButton3);
        button4 = (ImageButton)findViewById(R.id.imageButton4);

        Random rand = new Random();
        int len = picSign.length;
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
    }

}