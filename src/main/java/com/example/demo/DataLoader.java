package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ModelRepository repository;

    @Override
    public void run (String... strings) throws Exception{

        ModelCar modelCar = new ModelCar ("2017", "Toyota", "Camry");
        repository.save(modelCar);

        modelCar = new ModelCar ("2018", "Nissan", "Altima");
        repository.save(modelCar);

        modelCar = new ModelCar ("2018", "Kia", "Sonata");
        repository.save(modelCar);

    }
}
