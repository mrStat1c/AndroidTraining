package com.example.androidtraining.startAndroidCourse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtraining.R;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    CheckBox cb;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_android_course);
        this.tv = findViewById(R.id.textView);
        this.cb = findViewById(R.id.chbExtMenu);
        this.tv2 = findViewById(R.id.textView2);
        registerForContextMenu(this.tv2);//создавать контекстное меню для этого View
        registerForContextMenu(this.tv);//создавать контекстное меню для этого View
    }

    /**
     * Вызывается только при первом показе меню
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

    /**
     * Создает контекстное меню (меню при долгом нажатии на элемент)
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // в зависимости от View добавляем разные элементы меню
        switch (v.getId()) {
            case R.id.textView2: {
                menu.add(0, 1, 0, "Red");
                menu.add(0, 2, 0, "Green");
                menu.add(0, 3, 0, "Blue");
                break;
            }
            case R.id.textView: {
                menu.add(0, 4, 0, "AAA!");
                menu.add(0, 5, 0, "BBB!");
                menu.add(0, 6, 0, "CCC!");
                break;
            }
        }
    }

    /**
     * @param item Вызывается при клике по пункту контекстного меню
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                this.tv2.setTextColor(Color.RED);
                break;
            case 2:
                this.tv2.setTextColor(Color.GREEN);
                break;
            case 3:
                this.tv2.setTextColor(Color.BLUE);
                break;
            case 4:
                this.tv.setTextColor(Color.CYAN);
                break;
            case 5:
                this.tv.setTextColor(Color.YELLOW);
                break;
            case 6:
                this.tv.setTextColor(Color.DKGRAY);
                break;
        }
        return super.onContextItemSelected(item);
    }
}