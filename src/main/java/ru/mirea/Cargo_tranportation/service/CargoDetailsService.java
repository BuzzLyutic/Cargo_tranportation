package ru.mirea.Cargo_tranportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.Cargo_tranportation.DTO.CargoDetailsDTO;
import ru.mirea.Cargo_tranportation.model.CargoDetails;
import ru.mirea.Cargo_tranportation.repository.CargoDetailsRepository;

import java.util.List;

@Service
public class CargoDetailsService {
    @Autowired
    private CargoDetailsRepository cargoDetailsRepository;

    public CargoDetails createCargoDetails(CargoDetailsDTO cargoDetailsDTO) {
        CargoDetails cargoDetails = new CargoDetails();
        cargoDetails.setOrderId(cargoDetailsDTO.getOrderId());
        cargoDetails.setWeight(cargoDetailsDTO.getWeight());
        cargoDetails.setDimensions(cargoDetailsDTO.getDimensions());
        return cargoDetailsRepository.save(cargoDetails);
    }

    public List<CargoDetails> getCargoDetailsByOrder(Long orderId) {
        return cargoDetailsRepository.findByOrderId(orderId);
    }
}
