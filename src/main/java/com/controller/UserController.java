package com.controller;

import com.data.UserRepository;
import com.data.UserRepository;
import com.model.User;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping()
    public void addUser(User user) {
        userRepository.save(user);
    }

    @PutMapping()
    public void updateUser(@RequestBody User updatedUser) {
        User originalUser = userRepository.findById(updatedUser.getId()).get();
        originalUser.setName(updatedUser.getName());
    }

}

