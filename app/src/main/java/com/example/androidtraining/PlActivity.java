package com.example.androidtraining;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlActivity extends AppCompatActivity {

    private TextView plList;

    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.pl_layout);

        plList = findViewById(R.id.tv_pl_names);
        plList.append("\n\n");
        String[] names = {"Java", "Python", "C#", "Kotlin", "Ruby", "Swift", "Go",
        "Rust", "Delphi", "Objective C"};
        for (String name: names){
            plList.append(name + "\n");
        }
    }
}
