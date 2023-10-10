package com.vasile.linga.models.CarTypes;

import com.vasile.linga.models.Car;
import com.vasile.linga.models.EngineTypes.ElectricEngine;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ElectricCar extends Car {
    private final ElectricEngine engine;

    public ElectricCar(String vin, String brand, String model, int prodYear, double price, int stateRating, ElectricEngine engine) {
        super(vin, brand, model, prodYear, price, stateRating);
        this.engine = engine;
    }
}
