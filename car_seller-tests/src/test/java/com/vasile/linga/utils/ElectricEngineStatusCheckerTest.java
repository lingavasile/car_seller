package com.vasile.linga.utils;

import com.vasile.linga.ElectricalSystemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class ElectricEngineStatusCheckerTest {
    ElectricEngineStatusChecker electricEngineStatusChecker;
    @BeforeEach
    void setup(){
        electricEngineStatusChecker = new ElectricEngineStatusChecker();
    }
    @Test
    @DisplayName("Should return true when battery capacity is 50%")
     void isVoltageEnough_ShouldReturnTrue() {
        Assertions.assertTrue(electricEngineStatusChecker.isBatteryEnough(50));
    }

    @Test
    @DisplayName("Should return true when battery capacity is 100%")
    void isVoltageEnough_BatteryIs100_ShouldReturnTrue() {
        Assertions.assertTrue(electricEngineStatusChecker.isBatteryEnough(100));
    }

    @Test
    @DisplayName("Should return false when battery capacity is 5%")
    void isVoltageEnough_ShouldReturnFalse() {
        Assertions.assertFalse(electricEngineStatusChecker.isBatteryEnough(5));
    }

    @Test
    @DisplayName("Should return false when battery capacity is 0%")
    void isVoltageEnough_BatteryIs0_ShouldReturnFalse() {
        Assertions.assertFalse(electricEngineStatusChecker.isBatteryEnough(0));
    }

    @Test
    @DisplayName("Should throw ElectricalSystemException when battery capacity is less than 0 and greater than 100")
    void isVoltageEnough_ShouldThrowElectricalSystemException() {
        Assertions.assertThrows(ElectricalSystemException.class,() -> electricEngineStatusChecker.isBatteryEnough(120));
        Assertions.assertThrows(ElectricalSystemException.class,() -> electricEngineStatusChecker.isBatteryEnough(-20));
    }
}
