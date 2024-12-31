package org.example.vizucarapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.vizucarapi.api.model.Car;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars;

    public CarService() {
        loadCars();
    }

    private void loadCars() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/data/vizucar-bdd.json")) {
            if (inputStream == null) {
                throw new RuntimeException("File not found: /data/vizucar-bdd.json");
            }
            List<Car> loadedCars = objectMapper.readValue(inputStream, new TypeReference<List<Car>>() {});

            // Generate IDs for each car if missing
            for (int i = 0; i < loadedCars.size(); i++) {
                loadedCars.get(i).setId(i + 1); // Generate a unique ID starting from 1
            }

            cars = loadedCars;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load car data", e);
        }
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car getCarById(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
