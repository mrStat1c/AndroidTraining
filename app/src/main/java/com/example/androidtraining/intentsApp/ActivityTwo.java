package com.example.androidtraining.intentsApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidtraining.R;

public class ActivityTwo extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        this.textView = findViewById(R.id.tv_display);

        // вывод данных, пришедших из ActivityOne
        Intent intentStartedThisActivity = getIntent();
        if(intentStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)){
            String textEntered = intentStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
            this.textView.setText(textEntered);
        }
    }
}