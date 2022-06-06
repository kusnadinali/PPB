package com.example.ligasepakbola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView klub;
    ArrayList<Klub> list;
    KlubAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Klub>();
        // get data
        Klub k1 = new Klub("Bali United",69,31,21,6,4,52,22,30);
        list.add(k1);
        Klub k2 = new Klub("Persib",66,31,20,6,5,46,20,26);
        list.add(k2);
        Klub k3 = new Klub("Persebaya",59,31,17,8,6,51,32,19);
        list.add(k3);
        Klub k4 = new Klub("Bhayangkara",59,31,17,6,4,41,26,15);
        list.add(k4);
        Klub k5 = new Klub("Arema",58,31,16,10,5,38,22,16);
        list.add(k5);

        klub = findViewById(R.id.recyclerView);
        adapter = new KlubAdapter(this, list);
        klub.setAdapter(adapter);
        klub.setLayoutManager(new LinearLayoutManager(this));


    }
}