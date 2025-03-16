package br.com.geosapiens.controller;

import br.com.geosapiens.dto.UserDTO;
import br.com.geosapiens.mapper.UserMapper;
import br.com.geosapiens.model.User;
import br.com.geosapiens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(userMapper.toUserDTO(createdUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(userMapper.toUserDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream()
                                      .map(userMapper::toUserDTO)
                                      .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }
}