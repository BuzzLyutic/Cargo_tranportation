package ru.mirea.Cargo_tranportation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mirea.Cargo_tranportation.model.Order;
import ru.mirea.Cargo_tranportation.model.User;
import ru.mirea.Cargo_tranportation.repository.OrderRepository;
import ru.mirea.Cargo_tranportation.repository.UserRepository;
import ru.mirea.Cargo_tranportation.service.OrderService;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ModelAndView getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("orders");
        modelAndView.addObject("orders", orders);
        modelAndView.addObject("statuses", Arrays.asList("Pending",
                "In Transit", "Delivered", "Cancelled"));
        return modelAndView;
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ModelAndView getUsers() {
        List<User> users = userRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @PostMapping("orders/update-status")
    public String updateOrderStatus(@RequestParam Long orderId, @RequestParam String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/my-orders")
    public String showMyOrders(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        List<Order> orders = orderService.findOrdersWithDetailsByUserId(user.getUserId());
        model.addAttribute("orders", orders);
        return "myOrders";
    }

}
