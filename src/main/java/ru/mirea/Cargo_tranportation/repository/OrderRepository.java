package ru.mirea.Cargo_tranportation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.Cargo_tranportation.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
