package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_2.adapter.ProductListAdapter;
import com.example.assignment_2.service.ProductManager;

public class MainActivity extends AppCompatActivity {
    public static final String initialProductType = "Product Type";
    public static final String initialTotal = "Total";
    public static final String initialQuanity = "Quantity";

    private ProductManager manager;

    private Button[] numBtns;
    private Button buyBtn;
    private Button clearBtn;
    private Button managerBtn;
    private TextView productTypeTView;
    private TextView totalTView;
    private TextView qtyTView;
    private ProductListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialComponents();
        manager = new ProductManager();

        // Create the adapter to convert the array to views
        Log.d("list", manager.getProductList().toString());
        adapter = new ProductListAdapter(this, manager.getProductList(), manager, productTypeTView, qtyTView, totalTView);

        // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.productListView);
        listView.setAdapter(adapter);
    }

    private void initialComponents() {
        numBtns = new Button[10];
        numBtns[0] = findViewById(R.id.Btn_0);
        numBtns[1] = findViewById(R.id.Btn_1);
        numBtns[2] = findViewById(R.id.Btn_2);
        numBtns[3] = findViewById(R.id.Btn_3);
        numBtns[4] = findViewById(R.id.Btn_4);
        numBtns[5] = findViewById(R.id.Btn_5);
        numBtns[6] = findViewById(R.id.Btn_6);
        numBtns[7] = findViewById(R.id.Btn_7);
        numBtns[8] = findViewById(R.id.Btn_8);
        numBtns[9] = findViewById(R.id.Btn_9);
        buyBtn = findViewById(R.id.buyBtn);
        clearBtn = findViewById(R.id.Btn_clear);
        managerBtn = findViewById(R.id.Btn_manager);
        productTypeTView = findViewById(R.id.productType);
        productTypeTView.setText(initialProductType);
        totalTView = findViewById(R.id.total);
        totalTView.setText(initialTotal);
        qtyTView = findViewById(R.id.quantity);
        qtyTView.setText(initialQuanity);

        for(Button btn : numBtns) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button) v;
                    if(qtyTView.getText().equals(initialQuanity)) {
                        qtyTView.setText(b.getText());
                    } else {
                        qtyTView.append(b.getText());
                    }
                    if(!productTypeTView.getText().equals(initialProductType)) {
                        manager.getSelectedItem().setQty(Integer.parseInt(qtyTView.getText().toString()));
                        totalTView.setText(manager.getSelectedItem().getTotalAmount());
                    }
                }
            });
        }

        clearBtn.setOnClickListener(view -> {
            initUI();
        });

        buyBtn.setOnClickListener(view -> {
            if(productTypeTView.getText().equals(initialProductType) || qtyTView.getText().equals(initialQuanity)) {
                Toast.makeText(getApplicationContext(), R.string.required_error, Toast.LENGTH_LONG).show();
                return;
            }
            int qty = Integer.parseInt(qtyTView.getText().toString());
            if(qty > manager.getSelectedItem().getTotalQty()) {
                Toast.makeText(getApplicationContext(), R.string.qty_error, Toast.LENGTH_LONG).show();
                return;
            }
            manager.updateData(qty);

            AlertDialog.Builder confirm = new AlertDialog.Builder(this);
            confirm.setTitle("Thank You for your purchase");
            confirm.setMessage(manager.getSelectedItem().toString());
            AlertDialog alert = confirm.create();
            alert.show();
            initUI();
        });

        managerBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),ManagerActivity.class);
            intent.putExtra("historyList", manager.getHistoryList());
            startActivity(intent);
        });
    }

    private void initUI() {
        qtyTView.setText(initialQuanity);
        productTypeTView.setText(initialProductType);
        totalTView.setText(initialTotal);
        adapter.notifyDataSetChanged();
    }
}