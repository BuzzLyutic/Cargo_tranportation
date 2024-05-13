package ru.mirea.Cargo_tranportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.Cargo_tranportation.DTO.CostCalculationsDTO;
import ru.mirea.Cargo_tranportation.model.CostCalculations;
import ru.mirea.Cargo_tranportation.repository.CostCalculationsRepository;

import java.util.List;

@Service
public class CostCalculationsService {
    @Autowired
    private CostCalculationsRepository costCalculationsRepository;

    public CostCalculations createCostCalculations(CostCalculationsDTO costCalculationsDTO) {
        CostCalculations costCalculations = new CostCalculations();
        costCalculations.setOrderId(costCalculationsDTO.getOrderId());
        costCalculations.setBaseCost(costCalculationsDTO.getBaseCost());
        costCalculations.setAdditionalFees(costCalculationsDTO.getAdditionalFees());
        costCalculations.setTotalCost(costCalculationsDTO.getTotalCost());
        return costCalculationsRepository.save(costCalculations);
    }

    public List<CostCalculations> getCostCalculationsByOrder(Long orderId) {
        return costCalculationsRepository.findByOrderId(orderId);
    }
}
