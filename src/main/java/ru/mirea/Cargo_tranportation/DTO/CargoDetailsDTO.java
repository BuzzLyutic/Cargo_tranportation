package ru.mirea.Cargo_tranportation.DTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CargoDetailsDTO {
    private Long orderId;
    private Double weight;
    private String dimensions;

    // Constructors, getters, and setters
}
