package com.example.androidtraining.startAndroidCourse.simpleActivityResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidtraining.R;

public class NameActivity extends Activity {

    EditText etName;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_activity);

        this.etName = findViewById(R.id.etName);
        this.btnOK = findViewById(R.id.btnOK);
        this.btnOK.setOnClickListener(new ClickListener());
    }

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString());
            // setResult знает куда именно нужно отдать результат (в Activity, из которого был вызван startActivityForResult)
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
