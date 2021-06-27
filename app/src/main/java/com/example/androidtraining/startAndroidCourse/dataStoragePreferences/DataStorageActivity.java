package com.example.androidtraining.startAndroidCourse.dataStoragePreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidtraining.R;

public class DataStorageActivity extends Activity implements View.OnClickListener {

    EditText etText;
    Button btnSave, btnLoad;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_storage);

        etText = (EditText) findViewById(R.id.etText);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    void saveText() {
       //MODE_PRIVATE - данные будут доступны только этому приложению (??)
        this.sPref = getPreferences(MODE_PRIVATE);
        // для редактирования данных нужен объект SharedPreferences.Editor
        Editor ed = this.sPref.edit();
        ed.putString(this.SAVED_TEXT, this.etText.getText().toString());
        ed.commit();//IDE предлагает использовать вместо коммита ed.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        this.sPref = getPreferences(MODE_PRIVATE);
        String savedText = this.sPref.getString(this.SAVED_TEXT, "");
        this.etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}
