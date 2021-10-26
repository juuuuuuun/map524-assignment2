package com.example.assignment_2.service;

import com.example.assignment_2.model.History;
import com.example.assignment_2.model.Product;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> productList;
    private ArrayList<History> historyList;
    private Product selectedItem;

    public ProductManager() {
        productList = new ArrayList<>();
        productList.add(new Product("Pante", 20.44, 10));
        productList.add(new Product("Shoes", 10.44, 100));
        productList.add(new Product("Hats", 5.9, 30));

        historyList = new ArrayList<>();
        selectedItem = null;
    }

    public void updateData(int qty) {
        selectedItem.setQty(qty);
        selectedItem.setTotalQty(selectedItem.getTotalQty() - qty);
        historyList.add(new History(new Product(selectedItem.getName(), selectedItem.getPrice() * qty, 0, qty)));
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(ArrayList<History> historyList) {
        this.historyList = historyList;
    }

    public Product getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Product selectedItem) {
        this.selectedItem = selectedItem;
    }
}
