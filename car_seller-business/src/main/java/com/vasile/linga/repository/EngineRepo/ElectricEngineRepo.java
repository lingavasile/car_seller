package com.vasile.linga.repository.EngineRepo;

import com.vasile.linga.EngineNotFoundException;
import com.vasile.linga.interfaces.IElectricEngineReady;
import com.vasile.linga.interfaces.IElectricEngineStatusChecker;
import com.vasile.linga.models.EngineTypes.ElectricEngine;

public class ElectricEngineRepo implements IElectricEngineReady {

    IElectricEngineStatusChecker electricEngineStatusChecker;

    public ElectricEngineRepo(IElectricEngineStatusChecker electricEngineStatusChecker) {
        this.electricEngineStatusChecker = electricEngineStatusChecker;
    }

    @Override
    public boolean isReady(ElectricEngine engine) {
        if (engine == null) throw new EngineNotFoundException("Engine is null");
        return electricEngineStatusChecker.isBatteryEnough(engine.getBatteryLevel());
    }
}
