package com.vasile.linga.interfaces;

public interface IPetrolEngineStatusChecker {
    boolean isFuelAvailable(double fuelLevel);
    boolean isOilAvailable(double oilLevel);
    boolean isVoltageEnough(double voltage);
}
