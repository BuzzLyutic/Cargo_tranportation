package ru.mirea.Cargo_tranportation.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "cost_calculations")
public class CostCalculations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calculation_id")
    private Long calculationId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "base_cost")
    private Double baseCost;

    @Column(name = "additional_fees")
    private Double additionalFees;

    @Column(name = "total_cost")
    private Double totalCost;

    //@OneToOne
    //@JoinColumn(name = "order_id", referencedColumnName = "order_id")
    //private Order order;
    /*@Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;*/
}
