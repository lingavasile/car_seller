package com.vasile.linga.utils;

import com.vasile.linga.InvalidRatingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class DiscounterTest {

    StateEvaluator stateEvaluator;
    Discounter discounter;
    @BeforeEach
    void setup(){
        stateEvaluator = new StateEvaluator();
        discounter = new Discounter();
    }

    //Test stateCar function
    @Test
    @DisplayName("Should return 'Good' when stateRating is 60")
    void stateCar_shouldReturnGood(){
        String result = stateEvaluator.stateCar(60);
        Assertions.assertEquals(AutomobileState.GOOD_STATE,result);
    }

    @Test
    @DisplayName("Should return 'Better' when stateRating is 95")
    void stateCar_shouldReturnBetter(){
        String result = stateEvaluator.stateCar(95);
        Assertions.assertEquals(AutomobileState.BETTER_STATE,result);
    }

    @Test
    @DisplayName("Should return 'Old' when stateRating is 20")
    void stateCar_shouldReturnOld(){
        String result = stateEvaluator.stateCar(20);
        Assertions.assertEquals(AutomobileState.OLD_STATE,result);
    }

    @Test
    @DisplayName("Should throw InvalidRatingException when stateRating greater than 100")
    void stateCar_shouldThrowsInvalidRatingException(){
        Assertions.assertThrows(InvalidRatingException.class,() -> stateEvaluator.stateCar(150));
    }

    //Test discount function
    @Test
    @DisplayName("Should return price with 30% discount when stateRating is 'old'")
    void stateCar_shouldDiscount30percentOfPrice(){
        double result = discounter.discount(AutomobileState.OLD_STATE,4000);
        Assertions.assertEquals(2800,result);
    }

    @Test
    @DisplayName("Should return price with 10% discount when stateRating is 'good'")
    void stateCar_shouldDiscount10percentOfPrice(){
        double result = discounter.discount(AutomobileState.GOOD_STATE,4000);
        Assertions.assertEquals(3600,result);
    }

    @Test
    @DisplayName("Should return price when stateRating is 'better'")
    void stateCar_shouldReturnPrice(){
        double result = discounter.discount(AutomobileState.BETTER_STATE,4000);
        Assertions.assertEquals(4000,result);
    }
}
