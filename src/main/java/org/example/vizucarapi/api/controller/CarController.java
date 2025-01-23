package org.example.vizucarapi.api.controller;

import org.example.vizucarapi.api.model.Car;
import org.example.vizucarapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam String keyword) {
        return carService.searchCarsByKeyword(keyword);
    }

    @GetMapping
    public List<Car> getAllCars(
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String fuelType,
            @RequestParam(required = false) String gearbox,
            @RequestParam(required = false) String transmission,
            @RequestParam(required = false) String cylinders,
            @RequestParam(required = false) String color
    ) {
        if (make != null) {
            return carService.getCarsByMake(make);
        } else if (model != null) {
            return carService.getCarsByModel(model);
        } else if (year != null) {
            return carService.getCarsByYear(year);
        } else if (fuelType != null) {
            return carService.getCarsByFuelType(fuelType);
        } else if (gearbox != null) {
            return carService.getCarsByGearbox(gearbox);
        } else if (transmission != null) {
            return carService.getCarsByTransmission(transmission);
        } else if (cylinders != null) {
            return carService.getCarsByCylinders(Double.valueOf(cylinders));
        } else if (color != null) {
            return carService.getCarsByColor(color);
        }
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable String id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable String id) {
        carService.deleteCarById(id);
    }
}
