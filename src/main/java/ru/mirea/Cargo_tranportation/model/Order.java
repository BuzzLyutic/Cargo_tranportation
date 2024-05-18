package ru.mirea.Cargo_tranportation.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "dispatch_city")
    private String dispatchCity;

    @Column(name = "delivery_city")
    private String deliveryCity;

    @Column(name = "status")
    private String status;

}
