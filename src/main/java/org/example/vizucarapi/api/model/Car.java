package org.example.vizucarapi.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cars")
public class Car {

    @Id
    private String id;

    @Field("make")
    @TextIndexed // Indexed for text-based searches
    private String make;

    @Field("model")
    @TextIndexed // Indexed for text-based searches
    private String model;

    @Field("year")
    @Indexed // Standard index for fast filtering
    private Integer year;

    @Field("class")
    @JsonProperty("class")
    private String carClass;

    @Field("fueltype")
    @JsonProperty("fueltype")
    @Indexed // Standard index for fast filtering
    private String fuelType;

    @Field("gearbox")
    @Indexed // Standard index for fast filtering
    private String gearbox;

    @Field("transmission")
    @Indexed // Standard index for fast filtering
    private String transmission;

    @Field("cylinders")
    @Indexed // Standard index for fast filtering
    private Double cylinders;

    @Field("image_url")
    @JsonProperty("imageUrl")
    private String imageUrl;

    @Field("image_size")
    @JsonProperty("imageSize")
    private String imageSize;

    @Field("car_color")
    @Indexed // Standard index for fast filtering
    private String color;

    public Car() {
        this.cylinders = 0.0; // Default values
        this.imageUrl = "";
        this.imageSize = "unknown";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getCarClass() { return carClass; }
    public void setCarClass(String carClass) { this.carClass = carClass; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public String getGearbox() { return gearbox; }
    public void setGearbox(String gearbox) { this.gearbox = gearbox; }

    public String getTransmission() { return transmission; }
    public void setTransmission(String transmission) { this.transmission = transmission; }

    public Double getCylinders() { return cylinders; }
    public void setCylinders(Double cylinders) { this.cylinders = cylinders; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getImageSize() { return imageSize; }
    public void setImageSize(String imageSize) { this.imageSize = imageSize; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
