package org.example.vizucarapi.service;

import org.example.vizucarapi.api.model.Car;
import org.example.vizucarapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> searchCarsByKeyword(String keyword) {
        return carRepository.searchByKeyword(keyword);
    }


    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with ID: " + id));
    }

    public List<Car> getCarsByMake(String make) {
        return carRepository.findByMake(make);
    }

    public List<Car> getCarsByModel(String model) {
        return carRepository.findByModel(model);
    }

    public List<Car> getCarsByYear(Integer year) {
        return carRepository.findByYear(year);
    }

    public List<Car> getCarsByFuelType(String fuelType) {
        return carRepository.findByFuelType(fuelType);
    }

    public List<Car> getCarsByGearbox(String gearbox) {
        return carRepository.findByGearbox(gearbox);
    }

    public List<Car> getCarsByTransmission(String transmission) {
        return carRepository.findByTransmission(transmission);
    }

    public List<Car> getCarsByCylinders(Double cylinders) {
        if (cylinders == null) {
            throw new IllegalArgumentException("Cylinders value cannot be null");
        }
        return carRepository.findByCylinders(cylinders);
    }

    public List<Car> getCarsByColor(String color) {
        return carRepository.findByColor(color);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCarById(String id) {
        carRepository.deleteById(id);
    }
}
