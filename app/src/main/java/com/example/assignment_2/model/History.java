package com.example.assignment_2.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;

public class History extends Product implements Serializable {
    private Date date;

    public History() {
        super(null, 0, 0);
        date = new Date();
    }

    public History(Product p){
        super(p.getName(), p.getPrice(), 0, p.getQty());
        date = new Date();
    }

    public String getTotalAmount() {
        DecimalFormat format = new DecimalFormat("0.##");
        return format.format(getPrice());
    }
    //getter setter
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
