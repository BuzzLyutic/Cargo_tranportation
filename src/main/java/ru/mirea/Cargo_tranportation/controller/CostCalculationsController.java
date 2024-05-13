package ru.mirea.Cargo_tranportation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Cargo_tranportation.DTO.CostCalculationsDTO;
import ru.mirea.Cargo_tranportation.model.CostCalculations;
import ru.mirea.Cargo_tranportation.service.CostCalculationsService;

import java.util.List;

@RestController
@RequestMapping("/api/cost-calculations")
public class CostCalculationsController {
    @Autowired
    private CostCalculationsService costCalculationsService;

    @PostMapping
    public ResponseEntity<?> createCostCalculations(@RequestBody CostCalculationsDTO costCalculationsDTO) {
        CostCalculations costCalculations = costCalculationsService.createCostCalculations(costCalculationsDTO);
        return ResponseEntity.ok(costCalculations);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getCostCalculationsByOrder(@PathVariable Long orderId) {
        List<CostCalculations> costCalculations = costCalculationsService.getCostCalculationsByOrder(orderId);
        return ResponseEntity.ok(costCalculations);
    }
}
