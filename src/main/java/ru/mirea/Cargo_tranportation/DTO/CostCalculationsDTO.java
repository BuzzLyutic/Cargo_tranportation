package ru.mirea.Cargo_tranportation.DTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CostCalculationsDTO {
    private Long orderId;
    private Double baseCost;
    private Double additionalFees;
    private Double totalCost;

    // Constructors, getters, and setters
}
