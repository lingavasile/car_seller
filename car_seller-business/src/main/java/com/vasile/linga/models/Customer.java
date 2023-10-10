package com.vasile.linga.models;

import lombok.Data;
@Data
public class Customer {
    private int ID;
    private String fullName;
    private Car car;
    private double finalPrice;

    public Customer(int ID, String fullName) {
        this.ID = ID;
        this.fullName = fullName;
    }
}
