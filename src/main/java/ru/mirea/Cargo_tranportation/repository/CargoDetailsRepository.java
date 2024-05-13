package ru.mirea.Cargo_tranportation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.Cargo_tranportation.model.CargoDetails;

import java.util.List;

public interface CargoDetailsRepository extends JpaRepository<CargoDetails, Long> {
    List<CargoDetails> findByOrderId(Long orderId);
}
