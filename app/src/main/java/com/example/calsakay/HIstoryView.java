package com.example.calsakay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HIstoryView extends AppCompatActivity {

    Histories historiesList;
    TextView tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);

        Intent intent = getIntent();
        historiesList = (Histories) intent.getSerializableExtra("info");
        tv_test = findViewById(R.id.tv_test);
        tv_test.setText(historiesList.getFrontliner_id());


    }
}