package com.vasile.linga.repository.CarRepo;

import com.vasile.linga.EngineNotFoundException;
import com.vasile.linga.interfaces.IPetrolEngineReady;
import com.vasile.linga.interfaces.IFuelStarter;
import com.vasile.linga.models.EngineTypes.PetrolEngine;

public class PetrolCarRepo implements IFuelStarter {

    private final static String STARTED_STATE = "Started";
    private final static String WARNING_STATE = "Warning";
    private final IPetrolEngineReady iPetrolEngineReady;

    public PetrolCarRepo(IPetrolEngineReady iPetrolEngineReady) {
        this.iPetrolEngineReady = iPetrolEngineReady;
    }

    @Override
    public String startFuelEngine(PetrolEngine engine) {
        if (engine == null) throw new EngineNotFoundException("Engine is null");

        if(iPetrolEngineReady.isReady(engine)){
             return STARTED_STATE;
        }
        else return WARNING_STATE;
    }

}
