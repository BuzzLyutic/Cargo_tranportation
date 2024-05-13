package ru.mirea.Cargo_tranportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.Cargo_tranportation.DTO.OrderDTO;
import ru.mirea.Cargo_tranportation.model.Order;
import ru.mirea.Cargo_tranportation.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setOrderNumber(orderDTO.getOrderNumber());
        order.setDispatchCity(orderDTO.getDispatchCity());
        order.setDeliveryCity(orderDTO.getDeliveryCity());
        order.setStatus(orderDTO.getStatus());
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}

