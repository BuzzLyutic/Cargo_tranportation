package ru.mirea.Cargo_tranportation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mirea.Cargo_tranportation.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

    @Modifying
    @Query("UPDATE Order o SET o.status = :status")
    int updateStatus(@Param("status") String status);
}
