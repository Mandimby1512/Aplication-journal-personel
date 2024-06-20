package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<liste> listeArrayList;
    private listeAdapter adapter;
    private Databasemanager databasemanager;
    private Button addListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listeview);
        addListButton = findViewById(R.id.addliste);
        databasemanager = new Databasemanager(this);

        listeArrayList = databasemanager.getAllliste();
        adapter = new listeAdapter(this, listeArrayList);
        listView.setAdapter(adapter);

        addListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
