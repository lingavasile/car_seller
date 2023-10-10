package com.vasile.linga.utils;

import com.vasile.linga.InvalidRatingException;
import com.vasile.linga.interfaces.IDiscounter;
import com.vasile.linga.interfaces.IStateEvaluator;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Discounter implements IDiscounter {
    @Override
    public double discount(String stateRating, double price) {
        return switch (stateRating) {
            case AutomobileState.OLD_STATE -> price - ((price * 30) / 100);
            case AutomobileState.GOOD_STATE -> price - ((price * 10) / 100);
            default -> price;
        };
    }
}
