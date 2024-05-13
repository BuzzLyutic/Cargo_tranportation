package ru.mirea.Cargo_tranportation.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "cost_calculations")
public class CostCalculations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calculationId;
    private Long orderId;
    private Double baseCost;
    private Double additionalFees;
    private Double totalCost;

}
