package com.example.androidtraining.intentsApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidtraining.R;

public class ActivityOne extends AppCompatActivity {

    private EditText textEntry;
    private Button changeActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        this.textEntry = findViewById(R.id.et_text_entry);
        this.changeActivityButton = findViewById(R.id.change_activity);

        changeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textEntered = textEntry.getText().toString();

                Context context = ActivityOne.this;
                Class destinationActivity = ActivityTwo.class;

                // Intent создается для перехода на другой экран (Activity)
                Intent childActivityIntent = new Intent(context, destinationActivity);
                //вместо константы Intent.EXTRA_TEXT, можно использовать собственный String ключ
                childActivityIntent.putExtra(Intent.EXTRA_TEXT, textEntered);
                startActivity(childActivityIntent);
            }
        });

    }
}