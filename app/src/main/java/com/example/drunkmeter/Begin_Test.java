package com.example.drunkmeter;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;


public class Begin_Test extends AppCompatActivity {

    private static final String TAG = "BeginTest";

    public static ArrayList<PastResEntry> PastResultEntries = new ArrayList<PastResEntry>();
    public static ArrayList<Integer> ratingValues = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: before call to signGame");

        Intent intent = new Intent(Begin_Test.this, SignGame.class);
        startActivity(intent);

        Log.e(TAG, "onCreate: "+ratingValues.get(0));


    }
}

