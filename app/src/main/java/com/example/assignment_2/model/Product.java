package com.example.assignment_2.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Objects;

public class Product implements Serializable {
    private String name;
    private double price;
    private int qty;
    private int totalQty;

    public Product(String name, double price, int totalQty){
        this(name, price, totalQty, 0);
    }

    public Product(String name, double price, int totalQty, int qty){
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.totalQty = totalQty;
    }

    public String getTotalAmount(){
        DecimalFormat format = new DecimalFormat("0.##");
        return format.format(price * qty);
    }

    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double qty) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    @Override
    public String toString() {
        return "Your purchase is " + qty + " " + name + " for " + getTotalAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
