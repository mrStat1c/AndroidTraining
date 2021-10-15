package com.example.androidtraining.startAndroidCourse.simpleListView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidtraining.R;

public class simpleListViewActivity extends Activity implements View.OnClickListener {

    //Можно задавать массив т.о., но лучше задать его в res/values/strings.xml
//    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
//            "Костя", "Игорь", "Анна", "Денис", "Андрей" };

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list_view);

        // находим список
        this.lvMain = (ListView) findViewById(R.id.lvMain);

        // устанавливаем режим выбора пунктов списка (также есть ListView.CHOICE_MODE_SINGLE)
        this.lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //список будет хранить позицию последнего нажатого пункта и мы всегда можем запросить у него эту информацию

        // создаем адаптер
        // в качестве View можно добавить свой
        // R.layout.my_list_item
        // или использовать системные: android.R.layout.simple_list_item_1,
        // android.R.layout.simple_list_item_single_choice, android.R.layout.simple_list_item_multiple_choice и т.д.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names, android.R.layout.simple_list_item_multiple_choice);

        // присваиваем адаптер списку
        this.lvMain.setAdapter(adapter);

        Button btnChecked = (Button) findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        // получаем массив из файла ресурсов
        this.names = getResources().getStringArray(R.array.names);

    }

    public void onClick(View arg0) {
        // пишем в лог выделенные элементы
        Log.d(LOG_TAG, "checked: ");
        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
        //SparseBooleanArray представляет собой Map(int, boolean). Ключ – это позиция элемента,
        // а значение – это выделен пункт списка или нет.
        // SparseBooleanArray хранит инфу только о тех пкнктах, с которыми проводили действие (выделяли и снимали выделение)
        for (int i = 0; i < sbArray.size(); i++) {
            int key = sbArray.keyAt(i);
            if (sbArray.get(key))
                Log.d(LOG_TAG, names[key]);
        }
    }
}
