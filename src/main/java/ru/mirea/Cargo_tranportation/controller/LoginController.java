package ru.mirea.Cargo_tranportation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Cargo_tranportation.model.User;
import ru.mirea.Cargo_tranportation.repository.UserRepository;
import ru.mirea.Cargo_tranportation.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return "loginForm";
        }

        // Attempt to find the user in the database
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser!= null && userService.checkPassword(foundUser, user.getPassword())) {
            // Login successful, redirect to a success page
            //foundUser.getPassword().equals(user.getPassword()))
            return "redirect:/dashboard";
        } else {
            // Login failed, return to the login form
            return "loginForm";
        }
    }
}
