package ru.mirea.Cargo_tranportation.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.mirea.Cargo_tranportation.DTO.CargoDetailsDTO;
import ru.mirea.Cargo_tranportation.DTO.OrderDTO;
import ru.mirea.Cargo_tranportation.model.CargoDetails;
import ru.mirea.Cargo_tranportation.model.CostCalculations;
import ru.mirea.Cargo_tranportation.model.Order;
import ru.mirea.Cargo_tranportation.repository.CargoDetailsRepository;
import ru.mirea.Cargo_tranportation.repository.CostCalculationsRepository;
import ru.mirea.Cargo_tranportation.repository.OrderRepository;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CargoDetailsRepository cargoDetailRepository;
    @Autowired
    private CostCalculationsRepository costCalculationRepository;

    @Transactional
    public void createOrder(OrderDTO orderDTO, CargoDetailsDTO cargoDetailsDTO) {
        // Create and save Order
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setDispatchCity(orderDTO.getDispatchCity());
        order.setDeliveryCity(orderDTO.getDeliveryCity());
        order.setStatus("Pending");
        Order savedOrder = orderRepository.save(order);

        // Create and save CargoDetail
        CargoDetails cargoDetail = new CargoDetails();
        cargoDetail.setOrderId(savedOrder.getOrderId());
        cargoDetail.setWeight(cargoDetailsDTO.getWeight());
        cargoDetail.setDimensions(cargoDetailsDTO.getDimensions());
        cargoDetailRepository.save(cargoDetail);

        // Calculate costs and save CostCalculation
        double baseCost = calculateBaseCost(cargoDetailsDTO);
        double additionalFees = calculateAdditionalFees(orderDTO);
        double totalCost = baseCost + additionalFees;

        CostCalculations costCalculation = new CostCalculations();
        costCalculation.setOrderId(savedOrder.getOrderId());
        costCalculation.setBaseCost(baseCost);
        costCalculation.setAdditionalFees(additionalFees);
        costCalculation.setTotalCost(totalCost);
        costCalculationRepository.save(costCalculation);


    }

    private double calculateBaseCost(CargoDetailsDTO cargoDetail) {
        double baseCost = 100; // Base cost per kg
        return baseCost + Math.max(cargoDetail.getWeight(), cargoDetail.getDimensions() * 0.001);
    }

    private double getDistance(String dispatchCity, String deliveryCity) {
        // Simplified distance calculation for demonstration purposes
        Map<String, Double> distances = new HashMap<>();
        distances.put("CityA-CityB", 200.0);
        distances.put("CityA-CityC", 150.0);
        distances.put("CityB-CityC", 250.0);

        return distances.getOrDefault(dispatchCity + "-" + deliveryCity, 0.0);
    }

    private double calculateAdditionalFees(OrderDTO orderDTO) {
        double distanceBetweenCities = getDistance(orderDTO.getDispatchCity(), orderDTO.getDeliveryCity()); // Assume this method exists and calculates distance
        // Implement additional fees calculation logic
        return distanceBetweenCities * 0.5; // Placeholder
    }

    public List<Order> findOrdersWithDetailsByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public void updateStatusOfAllOrders(String status) {
        orderRepository.updateStatus(status);
    }

}