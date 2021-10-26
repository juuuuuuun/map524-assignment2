package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.assignment_2.model.History;

public class HistoryDetailActivity extends AppCompatActivity {

    private TextView productTView;
    private TextView priceTView;
    private TextView dateTView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        productTView = findViewById(R.id.history_detail_product);
        priceTView = findViewById(R.id.history_detail_price);
        dateTView = findViewById(R.id.history_detail_date);

        Intent intent = getIntent();
        History history = (History) intent.getSerializableExtra("history");
        productTView.setText("Product: " + history.getName());
        priceTView.setText("Price: " + history.getTotalAmount());
        dateTView.setText("Purchase Date: " + history.toString());
    }
}