package vizucar_api.api.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Car {
    @Id
    private String id;
    private String make;
    private String model;
    private Integer year;
    private String classe;
    private String fuelType;
    private String gearbox;
    private String transmission;
    private Double cylinders;
    private String urlimage;

    public Car(String make,
               String model,
               String fuelType,
               String classe,
               Integer year,
               String gearbox,
               String transmission,
               Double cylinders,
               String urlimage) {
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.classe = classe;
        this.year = year;
        this.gearbox = gearbox;
        this.transmission = transmission;
        this.cylinders = cylinders;
        this.urlimage = urlimage;
    }
}
