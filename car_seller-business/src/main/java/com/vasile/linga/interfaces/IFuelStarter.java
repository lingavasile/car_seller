package com.vasile.linga.interfaces;

import com.vasile.linga.models.EngineTypes.ElectricEngine;
import com.vasile.linga.models.EngineTypes.PetrolEngine;

public interface IFuelStarter {
     String startFuelEngine(PetrolEngine engine);
}
