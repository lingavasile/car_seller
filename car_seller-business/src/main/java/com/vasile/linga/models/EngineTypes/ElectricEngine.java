package com.vasile.linga.models.EngineTypes;

import com.vasile.linga.models.Engine;
import lombok.Data;

@Data
public class ElectricEngine extends Engine {
    private double batteryLevel;

    public ElectricEngine(String serialNumber, String model, int mileage, double volume, int powerHP, double batteryLevel) {
        super(serialNumber, model, mileage, volume, powerHP);
        this.batteryLevel = batteryLevel;
    }

}
