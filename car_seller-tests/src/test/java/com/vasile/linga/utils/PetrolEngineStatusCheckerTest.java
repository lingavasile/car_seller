package com.vasile.linga.utils;

import com.vasile.linga.ElectricalSystemException;
import com.vasile.linga.FuelLevelException;
import com.vasile.linga.OilLevelException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class PetrolEngineStatusCheckerTest {

    PetrolEngineStatusChecker petrolEngineStatusChecker;
    @BeforeEach
    void setup(){
        petrolEngineStatusChecker = new PetrolEngineStatusChecker();
    }

    @Test
    @DisplayName("Should return true when fuel level is 40")
    void test_isFuelAvailable_ShouldReturnTrue(){
        Assertions.assertTrue(petrolEngineStatusChecker.isFuelAvailable(40));
    }

    @Test
    @DisplayName("Should return true when fuel level is 100")
    void test_isFuelAvailable_ValueIs100_ShouldReturnTrue(){
        Assertions.assertTrue(petrolEngineStatusChecker.isFuelAvailable(100));
    }

    @Test
    @DisplayName("Should return false when fuel level is 20")
    void test_isFuelAvailable_ShouldReturnFalse(){
        Assertions.assertFalse(petrolEngineStatusChecker.isFuelAvailable(20));
    }

    @Test
    @DisplayName("Should return false when fuel level is 0")
    void test_isFuelAvailable_ValueIs0_ShouldReturnFalse(){
        Assertions.assertFalse(petrolEngineStatusChecker.isFuelAvailable(0));
    }

    @Test
    @DisplayName("Should throw FuelLevelException when fuel level is less than 0")
    void test_isFuelAvailable_NegativeValue_ShouldThrowsFuelLevelException(){
        Assertions.assertThrows(FuelLevelException.class,() -> petrolEngineStatusChecker.isFuelAvailable(-20));
    }

    @Test
    @DisplayName("Should throw FuelLevelException when fuel level is greater than 100")
    void test_isFuelAvailable_GreaterThan100Value_ShouldThrowsFuelLevelException(){
        Assertions.assertThrows(FuelLevelException.class,() -> petrolEngineStatusChecker.isFuelAvailable(120));
    }




    //IsOilAvailable function
    @Test
    @DisplayName("Should return true when oil level is 60")
    void test_isOilAvailable_ShouldReturnTrue(){
        Assertions.assertTrue(petrolEngineStatusChecker.isOilAvailable(60));
    }

    @Test
    @DisplayName("Should return true when oil level is 100")
    void test_isOilAvailable_OilLevelIs100_ShouldReturnTrue(){
        Assertions.assertTrue(petrolEngineStatusChecker.isOilAvailable(100));
    }

    @Test
    @DisplayName("Should return false when oil level is 50")
    void test_isOilAvailable_ShouldReturnFalse(){
        Assertions.assertFalse(petrolEngineStatusChecker.isOilAvailable(50));
    }

    @Test
    @DisplayName("Should return false when oil level is 0")
    void test_isOilAvailable_OilLevelIs0_ShouldReturnFalse(){
        Assertions.assertFalse(petrolEngineStatusChecker.isOilAvailable(0));
    }

    @Test
    @DisplayName("Should throw OilLevelException when oil level is less than 0")
    void test_isOilAvailable_NegativeValue_ShouldThrowsOilLevelException(){
        Assertions.assertThrows(OilLevelException.class,() -> petrolEngineStatusChecker.isOilAvailable(-8));
    }

    @Test
    @DisplayName("Should throw OilLevelException when oil level is less greater than 100")
    void test_isOilAvailable_GreaterThan100Value_ShouldThrowsOilLevelException(){
        Assertions.assertThrows(OilLevelException.class,() -> petrolEngineStatusChecker.isOilAvailable(200));
    }


    //IsVoltageEnough
    @Test
    @DisplayName("Should return true when battery voltage level is 12.8")
    void test_isVoltageEnough_ShouldReturnTrue(){
        Assertions.assertTrue(petrolEngineStatusChecker.isVoltageEnough(12.8));
    }

    @Test
    @DisplayName("Should return true when battery voltage level is 11.2")
    void test_isVoltageEnough_ShouldReturnFalse(){
        Assertions.assertFalse(petrolEngineStatusChecker.isVoltageEnough(11.2));
    }

    @Test
    @DisplayName("Should throw ElectricalSystemException when battery voltage level is negative")
    void test_isVoltageEnough_NegativeValue_ShouldThrowsElectricalSystemException(){
        Assertions.assertThrows(ElectricalSystemException.class,() -> petrolEngineStatusChecker.isVoltageEnough(-8));
    }

    @Test
    @DisplayName("Should throw ElectricalSystemException when battery voltage level is greater than 15")
    void test_isVoltageEnough_GreaterThan100Value_ShouldThrowsElectricalSystemException(){
        Assertions.assertThrows(ElectricalSystemException.class,() -> petrolEngineStatusChecker.isVoltageEnough(50));
    }


}
