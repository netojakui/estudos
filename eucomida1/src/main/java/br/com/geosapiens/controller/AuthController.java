package br.com.geosapiens.controller;

import br.com.geosapiens.dto.LoginDTO;
import br.com.geosapiens.model.User;
import br.com.geosapiens.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO user) {
        return ResponseEntity.ok(authService.authenticate(user.getUsername(), user.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }
}