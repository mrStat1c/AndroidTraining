package com.example.androidtraining.startAndroidCourse.simpleActivityResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.androidtraining.R;

public class SimpleActivityResult extends Activity {

    TextView tvName;
    Button btnName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_activity_result);

        this.tvName = findViewById(R.id.tvName);
        this.btnName = findViewById(R.id.btnName);
        this.btnName.setOnClickListener(new ClickListener());

    }

    /**
     * @param requestCode по нему определяем, с какого Activity пришел результат (в onClick() указан код "1")
     * @param resultCode код возврата. Определяет успешно прошел вызов или нет (сюда придет RESULT_OK из NameActivity)
     * @param data Intent, в котором возвращаются данные
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        String name = data.getStringExtra("name");
        tvName.setText("Your name is " + name);
    }

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Context context = SimpleActivityResult.this;
            Intent intent = new Intent(context, NameActivity.class);
            startActivityForResult(intent, 1);
        }
    }
}