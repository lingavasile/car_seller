package com.vasile.linga;

import com.vasile.linga.models.CarTypes.ElectricCar;
import com.vasile.linga.models.CarTypes.PetrolCar;
import com.vasile.linga.models.Customer;
import com.vasile.linga.models.EngineTypes.ElectricEngine;
import com.vasile.linga.models.EngineTypes.PetrolEngine;
import com.vasile.linga.repository.CarRepo.ElectricCarRepo;
import com.vasile.linga.repository.CarRepo.PetrolCarRepo;
import com.vasile.linga.repository.CustomerRepo.CustomerRepo;
import com.vasile.linga.repository.EngineRepo.ElectricEngineRepo;
import com.vasile.linga.repository.EngineRepo.PetrolEngineRepo;
import com.vasile.linga.utils.Discounter;
import com.vasile.linga.utils.ElectricEngineStatusChecker;
import com.vasile.linga.utils.PetrolEngineStatusChecker;
import com.vasile.linga.utils.StateEvaluator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;


import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        final Logger logger = (Logger)LogManager.getLogger(Main.class);

        PetrolEngineRepo petrolEngineRepo = new PetrolEngineRepo(new PetrolEngineStatusChecker());
        PetrolCarRepo petrolCarRepo = new PetrolCarRepo(petrolEngineRepo);

        ElectricEngineRepo electricEngineRepo = new ElectricEngineRepo(new ElectricEngineStatusChecker());
        ElectricCarRepo electricCarRepository = new ElectricCarRepo(electricEngineRepo);

        Discounter discounter = new Discounter();
        StateEvaluator stateEvaluator = new StateEvaluator();

        PetrolCar bmw_m3 = new PetrolCar("WBSCD0322VEE11260","BMW","M3 E36",1997,4000,70,
                           new PetrolEngine("HFJEJIU76657FEH","BM34M12",234135,3200,240,70,25,12.8));

        ElectricCar tesla_plaid = new ElectricCar("5YJSA1DP3CFF00035","Tesla","Model S",2020,400000,90,
                                  new ElectricEngine("L78757GDE8976","BM34M12",14135,2300,302,50));


        System.out.println(discounter.discount(stateEvaluator.stateCar(bmw_m3.getStateRating()), bmw_m3.getPrice()));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println(electricCarRepository.startElectricEngine(tesla_plaid.getEngine()));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------END----------------------------------------------------------------------------");
        CustomerRepo customerRepo = new CustomerRepo(new Discounter(),new StateEvaluator());

        List<Customer> customers;

        Customer customer = new Customer(1,"Linga Vasile");
        customerRepo.buyCar(bmw_m3,customer);

        Customer customer1 = new Customer(2,"Uzun Paula");
        customerRepo.buyCar(tesla_plaid,customer1);

        customers = asList(customer1,customer);


        for (var item : customers) {
            System.out.println("Customer:"+item.getFullName()+" bought "+item.getCar().getBrand()+" "+item.getCar().getModel()+" at price:"+item.getFinalPrice()+"€");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\nStarting: "+item.getCar().getBrand()+" "+item.getCar().getModel()+" .....");

            if (item.getCar().getClass().getName().equals("com.vasile.linga.models.CarTypes.ElectricCar")){
                logger.info("Initializing engine with status:" + electricCarRepository.startElectricEngine(((ElectricCar)item.getCar()).getEngine()));
            }else {
                logger.info("Initializing engine with status:" + petrolCarRepo.startFuelEngine(((PetrolCar)item.getCar()).getEngine()));
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        }

    }
}