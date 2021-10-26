package com.example.assignment_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.assignment_2.MainActivity;
import com.example.assignment_2.R;
import com.example.assignment_2.model.Product;
import com.example.assignment_2.service.ProductManager;

import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<Product> {

    private ProductManager manager;
    private TextView quantityTView;
    private TextView productTypeTView;
    private TextView totalTView;

    public ProductListAdapter(Context context, ArrayList<Product> users, ProductManager manager, TextView productTypeTView, TextView quantityTView, TextView totalTView) {
        super(context, 0, users);
        this.manager = manager;
        this.productTypeTView = productTypeTView;
        this.quantityTView = quantityTView;
        this.totalTView = totalTView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_view, parent, false);
        }

        // Get the data item for this position
        Product product = getItem(position);

        // Lookup view for data population
        LinearLayout layout = (LinearLayout) convertView.findViewById(R.id.product_view_item_layout);
        TextView name = (TextView) convertView.findViewById(R.id.product_view_name);
        TextView price = (TextView) convertView.findViewById(R.id.product_view_price);
        TextView totalQty = (TextView) convertView.findViewById(R.id.product_view_total_qty);

        // listener
        layout.setOnClickListener(view -> {
            manager.setSelectedItem(product);
            productTypeTView.setText(product.getName());
            if(!quantityTView.getText().equals(MainActivity.initialQuanity)) {
                manager.getSelectedItem().setQty(Integer.parseInt(quantityTView.getText().toString()));
                totalTView.setText(manager.getSelectedItem().getTotalAmount());
            }
        });

        // Populate the data into the template view using the data object
        name.setText(product.getName());
        price.setText(product.getPrice() + "");
        totalQty.setText(product.getTotalQty() + "");
        // Return the completed view to render on screen
        return convertView;
    }
}
