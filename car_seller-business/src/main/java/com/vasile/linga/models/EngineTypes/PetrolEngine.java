package com.vasile.linga.models.EngineTypes;

import com.vasile.linga.models.Engine;
import lombok.Data;

@Data
public class PetrolEngine extends Engine {
    private double oilLevel;
    private double fuelLevel;
    private double batteryVoltage;

    public PetrolEngine(String serialNumber, String model, int mileage, double volume, int powerHP, double oilLevel, double fuelLevel, double batteryVoltage) {
        super(serialNumber, model, mileage, volume, powerHP);
        this.oilLevel = oilLevel;
        this.fuelLevel = fuelLevel;
        this.batteryVoltage = batteryVoltage;
    }

}
