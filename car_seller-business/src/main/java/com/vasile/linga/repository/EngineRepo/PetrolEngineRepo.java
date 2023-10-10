package com.vasile.linga.repository.EngineRepo;

import com.vasile.linga.EngineNotFoundException;
import com.vasile.linga.interfaces.IPetrolEngineReady;
import com.vasile.linga.interfaces.IPetrolEngineStatusChecker;
import com.vasile.linga.models.EngineTypes.PetrolEngine;

public class PetrolEngineRepo implements IPetrolEngineReady {
    IPetrolEngineStatusChecker petrolEngineStatusChecker;
    public PetrolEngineRepo(IPetrolEngineStatusChecker petrolEngineStatusChecker) {
        this.petrolEngineStatusChecker = petrolEngineStatusChecker;
    }



    @Override
    public boolean isReady(PetrolEngine engine) {
        if (engine == null) throw new EngineNotFoundException("Engine is null");
        return petrolEngineStatusChecker.isFuelAvailable(engine.getFuelLevel()) &&
                petrolEngineStatusChecker.isOilAvailable(engine.getOilLevel()) &&
                petrolEngineStatusChecker.isVoltageEnough(engine.getBatteryVoltage());
    }
}
