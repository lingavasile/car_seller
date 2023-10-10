package com.vasile.linga.interfaces;

import com.vasile.linga.models.Car;
import com.vasile.linga.models.Customer;

public interface ICustomerRepo {
     void buyCar(Car car, Customer customer);
}
