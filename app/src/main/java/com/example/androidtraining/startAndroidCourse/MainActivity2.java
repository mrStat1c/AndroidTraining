package com.example.androidtraining.startAndroidCourse;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining.R;

// исплементация обработчика для реаширования на изменения полосы прокрутки
public class MainActivity2 extends AppCompatActivity {

    SeekBar sbWeight;
    Button btn1;
    Button btn2;

    TextView textView;
    Animation animation;

    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_android_course2);

        this.sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        this.btn1 = (Button) findViewById(R.id.btn1);
        this.btn2 = (Button) findViewById(R.id.btn2);
        this.textView = findViewById(R.id.tv);

        this.lParams1 = (LinearLayout.LayoutParams) this.btn1.getLayoutParams();
        this.lParams2 = (LinearLayout.LayoutParams) this.btn2.getLayoutParams();

        //обработчик для полосы прокрутки
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            /** срабатывает все время, пока значение меняется
             * @param progress
             * @param fromUser
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int leftValue = progress;
                int rightValue = seekBar.getMax() - progress;
                // настраиваем вес
                lParams1.weight = leftValue;
                lParams2.weight = rightValue;
                // в текст кнопок пишем значения переменных
                btn1.setText(String.valueOf(leftValue));
                btn2.setText(String.valueOf(rightValue));
            }

            /**
             * срабатывает, когда начинаем тащить ползунок
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            /**
             * срабатывает, когда отпускаем ползунок
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        this.sbWeight.setOnSeekBarChangeListener(onSeekBarChangeListener);

        View.OnClickListener tvOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // можно передовать любые другие анимации и res/anim
                animation = AnimationUtils.loadAnimation(textView.getContext(), R.anim.myrotate);
                textView.startAnimation(animation);
            }
        };
        this.textView.setOnClickListener(tvOnClick);
    }

}
