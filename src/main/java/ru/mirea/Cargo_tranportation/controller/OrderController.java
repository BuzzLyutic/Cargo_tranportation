package ru.mirea.Cargo_tranportation.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Collection;
import ru.mirea.Cargo_tranportation.DTO.CargoDetailsDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Cargo_tranportation.DTO.OrderDTO;
import ru.mirea.Cargo_tranportation.Security.CustomUserDetails;
import ru.mirea.Cargo_tranportation.model.Order;
import ru.mirea.Cargo_tranportation.service.OrderService;

import java.util.List;

@Controller
//@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/createOrder")
    public String showCreateOrderForm(Model model) {
        model.addAttribute("orderDTO", new OrderDTO());
        model.addAttribute("cargoDetailsDTO", new CargoDetailsDTO(null, null, null)); // Initialize with nulls or default values
        return "orderForm"; // Assuming this is the view name for your order form
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
    public String successfulOrder(){
        return "successPage";
    }

}
    /*@GetMapping
    public String showOrderForm(Model model, HttpSession session) {
        CustomAuthenticationToken customAuth = (CustomAuthenticationToken) session.getAttribute("SPRING_SECURITY_CONTEXT");
        Long userId = customAuth.getUserId();

        model.addAttribute("orderDTO", new OrderDTO(userId));
        return "orderForm";
    }

    @PostMapping
    public String submitOrder(@ModelAttribute OrderDTO orderDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "orderForm";
        }
        Order order = orderService.createOrder(orderDTO);
        return "redirect:/orderConfirmation/" + order.getOrderNumber();
    }
*/
    /*private Long getUserIdFromAuthentication(Authentication authentication) {
        // Assuming the user's ID is stored in the authorities of the Authentication object
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority instanceof SimpleGrantedAuthority) {
                String authorityName = ((SimpleGrantedAuthority) authority).getAuthority();
                // Assuming the user ID is encoded in the authority name, e.g., "USER_123"
                if (authorityName.startsWith("USER_")) {
                    return Long.parseLong(authorityName.substring(5)); // Extract the numeric part of the authority name
                }
            }
        }
        return null; // Fallback in case the user ID cannot be found
    }*/

