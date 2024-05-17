package ru.mirea.Cargo_tranportation.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


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

    //@OneToOne
   // @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    //private Order order;
    /*@Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;*/
}
