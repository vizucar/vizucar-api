package org.example.vizucarapi.api.controller;

import org.example.vizucarapi.api.model.Car;
import org.example.vizucarapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars(@RequestParam(required = false) Integer id) {
        if (id != null) {
            // Filter cars by ID if query parameter is provided
            Car car = carService.getCarById(id);
            return car != null ? List.of(car) : List.of(); // Return the car if found, else an empty list
        }
        return carService.getAllCars(); // Otherwise, return all cars
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable int id) {
        return carService.getCarById(id);
    }
}
