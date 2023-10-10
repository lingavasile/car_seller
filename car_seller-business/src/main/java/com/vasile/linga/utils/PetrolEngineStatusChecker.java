package com.vasile.linga.utils;
import com.vasile.linga.ElectricalSystemException;
import com.vasile.linga.FuelLevelException;
import com.vasile.linga.OilLevelException;
import com.vasile.linga.interfaces.IPetrolEngineStatusChecker;

public class PetrolEngineStatusChecker implements IPetrolEngineStatusChecker {
    @Override
    public boolean isFuelAvailable(double fuelLevel) {

        if ((fuelLevel>=30) && (fuelLevel<=100))
        return true;
        else if ((fuelLevel > 100) || (fuelLevel < 0)) throw new FuelLevelException("Invalid fuelLevel");
        else return false;
    }

    @Override
    public boolean isOilAvailable(double oilLevel) {

        if ((oilLevel>=60) && (oilLevel<=100))
        return true;
        else if ((oilLevel > 100) || (oilLevel < 0)) throw new OilLevelException("Invalid oilLevel");
        else return false;
    }

    @Override
    public boolean isVoltageEnough(double voltage) {

        if ((voltage >= 12.4) && (voltage <= 15.0))
        return true;
        else if ((voltage > 15) || (voltage < 0)) throw new ElectricalSystemException("Trouble in the electrical system");
        else return false;
    }
}
