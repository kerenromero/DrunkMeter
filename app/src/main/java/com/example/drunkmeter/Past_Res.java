package com.example.drunkmeter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class Past_Res extends AppCompatActivity {

    private ListView listView;
    public ArrayList<PastResEntry> PastResultEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past__res);

        listView = (ListView)findViewById(R.id.ListView);

        PastResultEntries = Begin_Test.PastResultEntries;

        EntriesAdapter adapter = new EntriesAdapter(this, R.layout.listview_layout, PastResultEntries);
        listView.setAdapter(adapter);



        

    }

}