package com.kanban.kanban_project.controller;

import com.kanban.kanban_project.model.User;
import com.kanban.kanban_project.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        if (userRepository.existsByDisplayName(user.getDisplayName())) {
            return ResponseEntity.badRequest().build(); // Display name must be unique
        }
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{displayName}")
    public ResponseEntity<User> updateUser(@PathVariable String displayName, @RequestBody User userDetails) {
        Optional<User> existingUser = userRepository.findByDisplayName(displayName);
        if (existingUser.isEmpty()) return ResponseEntity.notFound().build();

        User user = existingUser.get();

        // Only update non-null fields
        if (userDetails.getCity() != null) user.setCity(userDetails.getCity());
        if (userDetails.getState() != null) user.setState(userDetails.getState());
        if (userDetails.getZipcode() != null) user.setZipcode(userDetails.getZipcode());

        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{displayName}")
    public ResponseEntity<User> getUser(@PathVariable String displayName) {
        return userRepository.findByDisplayName(displayName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
