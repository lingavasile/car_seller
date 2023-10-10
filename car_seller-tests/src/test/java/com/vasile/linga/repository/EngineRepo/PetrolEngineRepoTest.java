package com.vasile.linga.repository.EngineRepo;

import com.vasile.linga.EngineNotFoundException;
import com.vasile.linga.interfaces.IPetrolEngineStatusChecker;
import com.vasile.linga.models.EngineTypes.PetrolEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
import static org.mockito.Mockito.when;

@Execution(CONCURRENT)
public class PetrolEngineRepoTest {
   public PetrolEngineRepo petrolEngineRepo;
   @Mock
   PetrolEngine engine;
   @Mock
   public IPetrolEngineStatusChecker petrolEngineStatusChecker;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        petrolEngineRepo = new PetrolEngineRepo(petrolEngineStatusChecker);
    }

    @Test
    @DisplayName("Should return true when getFuelLevel(),getOilLevel() and getBatteryVoltage() returns true")
    public void isReady_ShouldReturnTrue(){
        when(petrolEngineStatusChecker.isFuelAvailable(engine.getFuelLevel())).thenReturn(true);
        when(petrolEngineStatusChecker.isOilAvailable(engine.getOilLevel())).thenReturn(true);
        when(petrolEngineStatusChecker.isVoltageEnough(engine.getBatteryVoltage())).thenReturn(true);

        Assertions.assertTrue(petrolEngineRepo.isReady(engine));
    }

    @Test
    @DisplayName("Should return false when getFuelLevel() or getOilLevel() or getBatteryVoltage() returns false")
    public void isReady_ShouldReturnFalse(){
        when(petrolEngineStatusChecker.isFuelAvailable(engine.getFuelLevel())).thenReturn(false);
        when(petrolEngineStatusChecker.isOilAvailable(engine.getOilLevel())).thenReturn(true);
        when(petrolEngineStatusChecker.isVoltageEnough(engine.getBatteryVoltage())).thenReturn(true);

        Assertions.assertFalse(petrolEngineRepo.isReady(engine));
    }

    @Test
    @DisplayName("isReady() should throws EngineNotFoundException when engine is null")
    public void isReady_WhenEngineIsNull_ShouldThrowEngineNotFoundException(){
        Assertions.assertThrows(EngineNotFoundException.class,()->petrolEngineRepo.isReady(null));
    }
}
