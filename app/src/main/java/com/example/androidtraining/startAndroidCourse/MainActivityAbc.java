package com.example.androidtraining.startAndroidCourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivityAbc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // создание Layout не через XML, а программно
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        пар-ры для loyout
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        setContentView(linearLayout, layoutParams);

//        пар-ры для View
        LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        viewParams.leftMargin = 50;

        TextView tv = new TextView(this);
        tv.setText("TextView");
        tv.setLayoutParams(viewParams);
        linearLayout.addView(tv);

        Button btn = new Button(this);
        btn.setText("Button");
        linearLayout.addView(btn, viewParams);

        Button btn2 = new Button(this);
        btn.setText("CLEAR ALL");
        linearLayout.addView(btn, viewParams);
        View.OnClickListener btn2Click = v -> linearLayout.removeAllViews();
        btn2.setOnClickListener(btn2Click);
    }

}
