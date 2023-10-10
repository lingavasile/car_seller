package com.vasile.linga.repository.CarRepo;

import com.vasile.linga.EngineNotFoundException;
import com.vasile.linga.interfaces.IPetrolEngineReady;
import com.vasile.linga.models.EngineTypes.PetrolEngine;
import com.vasile.linga.utils.AutomobileState;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
import static org.mockito.Mockito.when;

@Execution(CONCURRENT)
public class PetrolCarRepoTest {

    @Mock
    IPetrolEngineReady mockPetrolEngineReady;
    PetrolCarRepo petrolCarRepo;
    @Mock
    PetrolEngine engine;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        petrolCarRepo = new PetrolCarRepo(mockPetrolEngineReady);

    }


    @Test
    @DisplayName("Test startFuelEngine() when Engine is ready should return 'Started'")
    void test_startFuelEngine_WhenEngineIsReady_ShouldReturnStarted(){
        when(mockPetrolEngineReady.isReady(engine)).thenReturn(true);
        String result = petrolCarRepo.startFuelEngine(engine);
        Assertions.assertEquals(AutomobileState.STARTED_STATE,result);
    }

    @Test
    @DisplayName("Test startFuelEngine() when Engine is not ready should return 'Warning'")
    void test_startFuelEngine_WhenEngineIsNotReady_ShouldReturnStarted(){
        when(mockPetrolEngineReady.isReady(engine)).thenReturn(false);
        String result = petrolCarRepo.startFuelEngine(engine);
        Assertions.assertEquals(AutomobileState.WARNING_STATE,result);
    }

    @Test
    @DisplayName("Test startFuelEngine() when Engine is null should throw EngineNotFoundException")
    void test_startFuelEngine_WhenEngineIsNull_ShouldThrowEngineNotFoundException(){
        Assertions.assertThrows(EngineNotFoundException.class,()-> petrolCarRepo.startFuelEngine(null));
    }
}
