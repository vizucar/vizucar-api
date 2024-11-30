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
}
