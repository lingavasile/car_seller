package com.vasile.linga.utils;

import com.vasile.linga.InvalidRatingException;
import com.vasile.linga.interfaces.IStateEvaluator;

public class StateEvaluator implements IStateEvaluator {
    @Override
    public String stateCar(int stateRating) {
        if ((stateRating >= 80) && (stateRating <= 100)){
            return AutomobileState.BETTER_STATE;
        }else if ((stateRating >= 50) && (stateRating < 80)){
            return AutomobileState.GOOD_STATE;
        }else if ((stateRating > 0) && (stateRating < 50)){
            return AutomobileState.OLD_STATE;
        } else throw new InvalidRatingException("Invalid Rating");
    }
}
