package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.assignment_2.model.History;

import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity {

    private Button historyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        historyBtn = findViewById(R.id.history_btn);

        ArrayList<History> historyList = (ArrayList<History>) getIntent().getSerializableExtra("historyList");

        historyBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),HistoryActivity.class);
            intent.putExtra("historyList", historyList);
            startActivity(intent);
        });
    }
}