package org.example.vizucarapi.service;

import org.example.vizucarapi.api.model.Car;
import org.example.vizucarapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Car findCarWithMaxYear(List<Car> cars) {
        Car maxYearCar = null;
        for (Car car : cars) {
            if (maxYearCar == null || car.getYear() > maxYearCar.getYear()) {
                maxYearCar = car;
            }
        }
        return maxYearCar;
    }

    public Car findCarWithMinYear(List<Car> cars) {
        Car minYearCar = null;
        for (Car car : cars) {
            if (minYearCar == null || car.getYear() < minYearCar.getYear()) {
                minYearCar = car;
            }
        }
        return minYearCar;
    }

    public List<Car> searchByMake(List<Car> cars, String make) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public List<Car> searchByModel(List<Car> cars, String model) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public List<Car> searchByYear(List<Car> cars, int year) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public List<Car> searchByFuelType(List<Car> cars, String fuelType) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getFuelType().equalsIgnoreCase(fuelType)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public List<Car> searchByGearbox(List<Car> cars, String gearbox) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getGearbox().equalsIgnoreCase(gearbox)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public List<Car> searchByTransmission(List<Car> cars, String transmission) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getTransmission().equalsIgnoreCase(transmission)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public List<Car> searchByCylinders(List<Car> cars, Double cylinders) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCylinders().equals(cylinders)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public List<Car> searchByColor(List<Car> cars, String color) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equalsIgnoreCase(color)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
