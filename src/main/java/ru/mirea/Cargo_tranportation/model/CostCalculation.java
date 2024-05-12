package ru.mirea.Cargo_tranportation.model;



@Entity
@Table(name = "cost_calculations")
public class CostCalculations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calculationId;
    private Long orderId;
    private Double baseCost;
    private Double additionalFees;
    private Double totalCost;

    // Constructors, getters, and setters
}
