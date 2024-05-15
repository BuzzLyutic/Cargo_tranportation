package ru.mirea.Cargo_tranportation.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Cargo_tranportation.model.User;
import ru.mirea.Cargo_tranportation.repository.UserRepository;
import ru.mirea.Cargo_tranportation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String showLoginForm(Model model, HttpServletRequest request) {
        if (request.getParameter("error")!= null) {
            model.addAttribute("error", "Invalid username or password.");
        }
        return "loginForm"; // Ensure you have a Thymeleaf template named loginForm.html
    }

    /*@Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager; // Inject AuthenticationManager

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        // Attempt to authenticate the user
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authenticationManager.authenticate(authentication); // Use AuthenticationManager to authenticate

        // If authentication is successful, redirect to the dashboard
        if (auth.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(auth); // Set the authentication in the security context
            return "redirect:/dashboard";
        } else {
            // If authentication fails, redirect back to the login form
            return "redirect:/login?error=true";
        }
    }*/
}

/*
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
            return "registrationForm";
        }
    }
}
*/