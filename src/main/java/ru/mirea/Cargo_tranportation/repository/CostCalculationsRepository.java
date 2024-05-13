package ru.mirea.Cargo_tranportation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.Cargo_tranportation.model.CostCalculations;

import java.util.List;

public interface CostCalculationsRepository extends JpaRepository<CostCalculations, Long> {
    List<CostCalculations> findByOrderId(Long orderId);
}
