package com.vasile.linga.repository.CarRepo;


import com.vasile.linga.EngineNotFoundException;
import com.vasile.linga.interfaces.IElectricEngineReady;
import com.vasile.linga.models.EngineTypes.ElectricEngine;
import com.vasile.linga.utils.AutomobileState;
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
public class ElectricCarRepoTest {

    @Mock
    IElectricEngineReady electricEngineReady;
    ElectricCarRepo electricCarRepo;
    @Mock
    ElectricEngine engine;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        electricCarRepo = new ElectricCarRepo(electricEngineReady);
    }

    @Test
    @DisplayName("Should return started when engine is ready")
    void test_startElectricEngine_whenEngineIsReady_ShouldReturnStarted(){
        when(electricEngineReady.isReady(engine)).thenReturn(true);
        String result = electricCarRepo.startElectricEngine(engine);

        Assertions.assertEquals(AutomobileState.STARTED_STATE,result);
    }

    @Test
    @DisplayName("Should return Warning when engine is not ready")
    void test_startElectricEngine_whenEngineIsReady_ShouldReturnWarning(){
        when(electricEngineReady.isReady(engine)).thenReturn(false);
        String result = electricCarRepo.startElectricEngine(engine);

        Assertions.assertEquals(AutomobileState.WARNING_STATE,result);
    }

    @Test
    @DisplayName("Should trow EngineNotFoundException when engine is null")
    void test_startElectricEngine_whenEngineIsNull_ShouldTrowsEngineNotFoundException(){
       Assertions.assertThrows(EngineNotFoundException.class,()->electricCarRepo.startElectricEngine(null));
    }




}
