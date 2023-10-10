package com.vasile.linga.repository.CustomerRepo;

import com.vasile.linga.CarNotFoundException;
import com.vasile.linga.CustomerNotFoundException;
import com.vasile.linga.interfaces.ICustomerRepo;
import com.vasile.linga.interfaces.IDiscounter;
import com.vasile.linga.interfaces.IStateEvaluator;
import com.vasile.linga.models.Car;
import com.vasile.linga.models.Customer;

public class CustomerRepo implements ICustomerRepo {

    IDiscounter discounter;
    IStateEvaluator stateEvaluator;

    public CustomerRepo(IDiscounter discounter, IStateEvaluator stateEvaluator) {
        this.discounter = discounter;
        this.stateEvaluator = stateEvaluator;
    }

    @Override
    public void buyCar(Car car, Customer customer) {
        if (customer != null){
            customer.setCar(car);
            if (customer.getCar() != null){
                var customerCar = customer.getCar();
                customer.setFinalPrice(discounter.discount(stateEvaluator.stateCar(customerCar.getStateRating()), customerCar.getPrice()));
            } else throw new CarNotFoundException("car is null");
        }else throw new CustomerNotFoundException("customer is null");
    }
}
