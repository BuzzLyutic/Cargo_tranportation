package ru.mirea.Cargo_tranportation.DTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CargoDetailsDTO {
    private Long orderId;
    private Double weight;
    private Double dimensions;

    public CargoDetailsDTO(Long orderId, Double weight, Double dimensions){
        this.orderId = orderId;
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getDimensions() {
        return dimensions;
    }
}
