package ru.mirea.Cargo_tranportation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Cargo_tranportation.DTO.CargoDetailsDTO;
import ru.mirea.Cargo_tranportation.model.CargoDetails;
import ru.mirea.Cargo_tranportation.service.CargoDetailsService;

import java.util.List;

/*@RestController
@RequestMapping("/api/cargo-details")
public class CargoDetailsController {

    @Autowired
    private CargoDetailsService cargoDetailsService;

    @PostMapping
    public ResponseEntity<?> createCargoDetails(@RequestBody CargoDetailsDTO cargoDetailsDTO) {
        CargoDetails cargoDetails = cargoDetailsService.createCargoDetails(cargoDetailsDTO);
        return ResponseEntity.ok(cargoDetails);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getCargoDetailsByOrder(@PathVariable Long orderId) {
        List<CargoDetails> cargoDetails = cargoDetailsService.getCargoDetailsByOrder(orderId);
        return ResponseEntity.ok(cargoDetails);
    }
}*/
