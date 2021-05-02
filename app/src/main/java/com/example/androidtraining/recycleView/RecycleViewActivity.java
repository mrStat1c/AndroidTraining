package com.example.androidtraining.recycleView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining.R;

public class RecycleViewActivity  extends AppCompatActivity {

    private RecyclerView numberList;
    private NumberAdapter numberAdapter;

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.rec_view_layout);

        this.numberList = findViewById(R.id.rv_numbers);

        // Manager настраивает то, как элементы распределяются/отображаются в RecycleView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.numberList.setLayoutManager(layoutManager);
        this.numberList.setHasFixedSize(true);

        // RecycleView обращается к Adapter, чтобы отображать список
        // Adapter в свою очередь обращается к источнику данных

        this.numberAdapter = new NumberAdapter(100, this);
        this.numberList.setAdapter(this.numberAdapter);

    }
}
