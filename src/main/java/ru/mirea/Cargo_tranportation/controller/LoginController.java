package ru.mirea.Cargo_tranportation.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Cargo_tranportation.DTO.UserDTO;
import ru.mirea.Cargo_tranportation.model.User;
import ru.mirea.Cargo_tranportation.repository.UserRepository;
import ru.mirea.Cargo_tranportation.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {


    @Autowired
    private UserRepository userRepository;

    private final UserService userService;

    @GetMapping("/")
    public String showHelloPage() {
        return "hello";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, HttpServletRequest request) {
        if (request.getParameter("error") != null) {
            model.addAttribute("error", "Invalid username or password.");
        }
        return "loginForm";
    }


    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registrationForm";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return "registrationForm";
        }

        // Save the user to the database
        userService.registerUser(userDTO);
        //userRepository.save(user);

        // Redirect to a success page or simply return a view name
        return "redirect:/login";
    }
}
