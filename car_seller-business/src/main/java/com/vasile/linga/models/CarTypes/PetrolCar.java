package com.vasile.linga.models.CarTypes;

import com.vasile.linga.models.Car;
import com.vasile.linga.models.EngineTypes.PetrolEngine;
import lombok.Data;

@Data
public class PetrolCar extends Car {
    private PetrolEngine engine;
    public PetrolCar(String vin, String brand, String model, int prodYear, double price, int stateRating,PetrolEngine engine) {
        super(vin, brand, model, prodYear, price, stateRating);
        this.engine = engine;
    }
}
