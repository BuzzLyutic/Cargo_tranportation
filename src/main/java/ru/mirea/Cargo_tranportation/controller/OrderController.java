package ru.mirea.Cargo_tranportation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import ru.mirea.Cargo_tranportation.DTO.CargoDetailsDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Cargo_tranportation.DTO.OrderDTO;
import ru.mirea.Cargo_tranportation.Security.CustomUserDetails;
import ru.mirea.Cargo_tranportation.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/createOrder")
    public String showCreateOrderForm(Model model) {
        model.addAttribute("orderDTO", new OrderDTO());
        model.addAttribute("cargoDetailsDTO", new CargoDetailsDTO(null, null, null));
        return "orderForm";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute("orderDTO") OrderDTO orderDTO,
                              @RequestParam("weight") Double weight,
                              @RequestParam("dimensions") String dimensions,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "orderForm";
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            Long userId = ((CustomUserDetails) principal).getId();
            orderDTO.setUserId(userId);
        }
        CargoDetailsDTO cargoDetailsDTO = new CargoDetailsDTO(null, weight, Double.parseDouble(dimensions));

        orderService.createOrder(orderDTO, cargoDetailsDTO);

        return "redirect:/orderSuccess";
    }

    @GetMapping("/orderSuccess")
    public String successfulOrder() {
        return "successPage";
    }

}


