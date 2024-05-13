package ru.mirea.Cargo_tranportation.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long userId;
    private String orderNumber;
    private String dispatchCity;
    private String deliveryCity;
    private String status;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;

}
