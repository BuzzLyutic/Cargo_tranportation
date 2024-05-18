package ru.mirea.Cargo_tranportation.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "cargo_details")
public class CargoDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long detailId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "dimensions")
    private Double dimensions;

}
