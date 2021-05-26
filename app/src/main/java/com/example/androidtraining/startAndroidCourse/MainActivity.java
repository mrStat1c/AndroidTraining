package com.example.androidtraining.startAndroidCourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtraining.R;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_android_course);
        this.tv = findViewById(R.id.textView);
        this.cb = findViewById(R.id.chbExtMenu);

    }

    /**
     * Вызывается только при первом показе меню
     *
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
//      groupId, itemId, order, title
//      order=0 - самый высокий
//      Также можно создать пункты меню при помощи XML-файла (res/menu)
        menu.add(0, 1, 0, "One");
        menu.add(0, 2, 0, "Two");
        menu.add(0, 3, 3, "Three");
        menu.add(1, 4, 1, "Four");
        menu.add(1, 5, 2, "Five");
        menu.add(1, 6, 4, "Six");
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Вызывается при нажатии пункта меню
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    /**
     * Вызывается каждый раз перед отображением меню
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // пункты меню с groupId=1 видны только если стоит чекбокс
        menu.setGroupVisible(1, this.cb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

}