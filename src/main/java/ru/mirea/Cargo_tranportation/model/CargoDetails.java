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
    private Long detailId;
    private Long orderId;
    private Double weight;
    private String dimensions;

}
