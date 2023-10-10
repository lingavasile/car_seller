package com.vasile.linga.models;

import lombok.Data;

@Data
public class Engine {

    private String serialNumber;
    private String model;
    private int mileage;
    private double volume;
    private int powerHP;

    public Engine(String serialNumber, String model, int mileage, double volume, int powerHP) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.mileage = mileage;
        this.volume = volume;
        this.powerHP = powerHP;
    }
}
