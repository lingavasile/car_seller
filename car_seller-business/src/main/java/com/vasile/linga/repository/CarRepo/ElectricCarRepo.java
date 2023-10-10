package com.vasile.linga.repository.CarRepo;

import com.vasile.linga.EngineNotFoundException;
import com.vasile.linga.interfaces.IElectricEngineReady;
import com.vasile.linga.interfaces.IElectricStarter;
import com.vasile.linga.models.EngineTypes.ElectricEngine;

public class ElectricCarRepo implements IElectricStarter {
    private final static String STARTED_STATE = "Started";
    private final static String WARNING_STATE = "Warning";
    private final IElectricEngineReady iElectricEngineReady;

    public ElectricCarRepo(IElectricEngineReady iElectricEngineReady) {
        this.iElectricEngineReady = iElectricEngineReady;
    }


    @Override
    public String startElectricEngine(ElectricEngine engine) {
        if (engine == null){
            throw new EngineNotFoundException("Engine is null");
        }
        if(iElectricEngineReady.isReady(engine)){
            return STARTED_STATE;
        }
        else {
            return WARNING_STATE;
        }
    }
}
