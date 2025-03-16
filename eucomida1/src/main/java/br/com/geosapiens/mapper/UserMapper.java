package br.com.geosapiens.mapper;

import br.com.geosapiens.dto.UserDTO;
import br.com.geosapiens.model.*;
import br.com.geosapiens.repository.RoleRepository;
import br.com.geosapiens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private RoleRepository roleRepository;

    public UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        if (user.getUserType() != null) {
            userDTO.setUserType(UserType.fromCode(user.getUserType()).getDescription());
        }
        userDTO.setIdRole(user.getRoles().stream().findAny().get().getId());
        return userDTO;
    }

    public User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        if (userDTO.getIdRole() != null) {
            Optional<Role> role = roleRepository.findById(userDTO.getIdRole());
            if (role.isPresent()) {
                List<Role> roles = role.map(Collections::singletonList).orElse(Collections.emptyList());
                user.setRoles((Set<Role>) roles);
            } else {
                throw new IllegalArgumentException("Product not found");
            }

        }
        return user;
    }
}