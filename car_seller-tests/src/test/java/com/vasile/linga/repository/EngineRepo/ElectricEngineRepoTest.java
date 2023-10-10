package com.vasile.linga.repository.EngineRepo;

import com.vasile.linga.EngineNotFoundException;
import com.vasile.linga.interfaces.IElectricEngineStatusChecker;
import com.vasile.linga.models.EngineTypes.ElectricEngine;
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
public class ElectricEngineRepoTest {

    ElectricEngineRepo electricEngineRepo;
    @Mock
    IElectricEngineStatusChecker iElectricEngineStatusChecker;
    @Mock
    ElectricEngine engine;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        electricEngineRepo = new ElectricEngineRepo(iElectricEngineStatusChecker);
    }

    @Test
    @DisplayName("Should return true when getBatteryLevel returns true")
    void isReady_ShouldReturnTrue(){
        when(iElectricEngineStatusChecker.isBatteryEnough(engine.getBatteryLevel())).thenReturn(true);

        Assertions.assertTrue(electricEngineRepo.isReady(engine));
    }

    @Test
    @DisplayName("Should return true when getBatteryLevel returns false")
    void isReady_ShouldReturnFalse(){
        when(iElectricEngineStatusChecker.isBatteryEnough(engine.getBatteryLevel())).thenReturn(false);

        Assertions.assertFalse(electricEngineRepo.isReady(engine));
    }

    @Test
    @DisplayName("isReady() Should throw EngineNotFoundException when engine is null ")
    void isReady_WhenEngineIsNull_ShouldThrowEngineNotFoundException(){
        Assertions.assertThrows(EngineNotFoundException.class,() -> electricEngineRepo.isReady(null));
    }
}
