package com.vasile.linga.models;

import lombok.Data;

@Data
public class Car {
    private String vin;
    private String brand;
    private String model;
    private int prodYear;
    private double price;
    private int stateRating;

    public Car(String vin, String brand, String model, int prodYear, double price,int stateRating) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.prodYear = prodYear;
        this.price = price;
        this.stateRating = stateRating;
    }

}
