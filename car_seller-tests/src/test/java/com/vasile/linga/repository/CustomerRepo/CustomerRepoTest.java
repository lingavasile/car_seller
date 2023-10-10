package com.vasile.linga.repository.CustomerRepo;

import com.vasile.linga.CarNotFoundException;
import com.vasile.linga.CustomerNotFoundException;
import com.vasile.linga.interfaces.IDiscounter;
import com.vasile.linga.interfaces.IStateEvaluator;
import com.vasile.linga.models.CarTypes.PetrolCar;
import com.vasile.linga.models.Customer;
import com.vasile.linga.models.EngineTypes.PetrolEngine;
import com.vasile.linga.utils.AutomobileState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Execution(CONCURRENT)
public class CustomerRepoTest {
    @Mock
    IDiscounter mockDiscounter;
    @Mock
    IStateEvaluator mockStateEvaluator;
    @Mock
    CustomerRepo customerRepo;
    @Mock
    Customer customer;
    PetrolCar bmw_m3;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        customerRepo = new CustomerRepo(mockDiscounter,mockStateEvaluator);
        bmw_m3 = new PetrolCar("GH3588JFEJ3523","BMW","M3 E46",2002,4000,60,
                new PetrolEngine("1252523JHJ35","BM34M12",234135,1600,120,70,25,12.8));
        customer = new Customer(1,"Linga Vasile");
    }

    @Test
    @DisplayName("Test buyCar function with non null customer and car")
    void test_buyCar_WithNonNullCustomerAndCar(){
        when(mockDiscounter.discount(anyString(),anyDouble())).thenReturn(3600.0);
        when(mockStateEvaluator.stateCar(anyInt())).thenReturn(AutomobileState.GOOD_STATE);

        customerRepo.buyCar(bmw_m3,customer);

        Assertions.assertEquals(bmw_m3,customer.getCar());
        Assertions.assertEquals(3600.0,customer.getFinalPrice(),0.01);

        verify(mockDiscounter).discount(AutomobileState.GOOD_STATE,4000);
        verify(mockStateEvaluator).stateCar(60);


    }

    @Test
    @DisplayName("Test buyCar function with null customer should throw CustomerNotFoundException")
    void test_buyCar_WithNUllCustomer(){
        CustomerNotFoundException exception = Assertions.assertThrows(CustomerNotFoundException.class, () -> customerRepo.buyCar(bmw_m3,null));

        Assertions.assertEquals("customer is null",exception.getMessage());
    }

    @Test
    @DisplayName("Test buyCar function with null car should throw CarNotFoundException")
    void test_buyCar_WithNUllCar(){
        CarNotFoundException exception = Assertions.assertThrows(CarNotFoundException.class, () -> customerRepo.buyCar(null,customer));

        Assertions.assertEquals("car is null",exception.getMessage());
    }
}
