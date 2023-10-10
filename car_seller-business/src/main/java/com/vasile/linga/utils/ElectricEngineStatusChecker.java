package com.vasile.linga.utils;

import com.vasile.linga.ElectricalSystemException;
import com.vasile.linga.interfaces.IElectricEngineStatusChecker;

public class ElectricEngineStatusChecker implements IElectricEngineStatusChecker {

    @Override
    public boolean isBatteryEnough(double batteryCapacity) {

        if ((batteryCapacity >= 10) && (batteryCapacity <= 100)) {
            return true;
        }
        else if ((batteryCapacity > 100) || (batteryCapacity < 0))
            throw new ElectricalSystemException("Trouble in the electrical system");
        else return false;

    }
}
