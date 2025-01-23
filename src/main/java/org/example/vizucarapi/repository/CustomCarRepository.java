package org.example.vizucarapi.repository;

import org.example.vizucarapi.api.model.Car;

import java.util.List;

public interface CustomCarRepository {
    List<Car> searchByKeyword(String keyword);
}