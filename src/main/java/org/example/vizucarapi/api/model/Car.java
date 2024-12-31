package org.example.vizucarapi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    private int id;
    private String make;
    private String model;
    private int year;
    private String carClass;
    private String fuelType;
    private String gearbox;
    private String transmission;
    private double cylinders;
    private String imageUrl;
    private String imageSize;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getCarClass() { return carClass; }
    public void setCarClass(String carClass) { this.carClass = carClass; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public String getGearbox() { return gearbox; }
    public void setGearbox(String gearbox) { this.gearbox = gearbox; }

    public String getTransmission() { return transmission; }
    public void setTransmission(String transmission) { this.transmission = transmission; }

    public double getCylinders() { return cylinders; }
    public void setCylinders(double cylinders) { this.cylinders = cylinders; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getImageSize() { return imageSize; }
    public void setImageSize(String imageSize) { this.imageSize = imageSize; }
}
