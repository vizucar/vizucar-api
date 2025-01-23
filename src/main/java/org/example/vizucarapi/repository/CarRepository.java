package org.example.vizucarapi.repository;

import org.example.vizucarapi.api.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String>, CustomCarRepository {
    List<Car> findByMake(String make);
    List<Car> findByModel(String model);
    List<Car> findByYear(Integer year); // Updated to Integer
    List<Car> findByFuelType(String fuelType);
    List<Car> findByGearbox(String gearbox);
    List<Car> findByTransmission(String transmission);
    List<Car> findByCylinders(Double cylinders);
    List<Car> findByColor(String color);
}
