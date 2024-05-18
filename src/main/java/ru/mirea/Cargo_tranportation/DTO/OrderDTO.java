package ru.mirea.Cargo_tranportation.DTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDTO {
    private Long userId;
    private String orderNumber;
    private String dispatchCity;
    private String deliveryCity;
    private String status;
    public OrderDTO() {} // Default constructor

    public OrderDTO(Long userId) { // Constructor accepting userId
        this.userId = userId;
    }


}
