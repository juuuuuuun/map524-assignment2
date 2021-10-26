package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.assignment_2.adapter.HistoryListAdapter;
import com.example.assignment_2.model.History;
import com.example.assignment_2.service.ProductManager;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    private History selectedHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        selectedHistory = new History();
        ArrayList<History> historyList = (ArrayList<History>) getIntent().getSerializableExtra("historyList");
        HistoryListAdapter adapter = new HistoryListAdapter(historyList, selectedHistory);
        RecyclerView recyclerView = findViewById(R.id.history_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}