package com.controller;

import com.data.UserRepository;
import com.model.AngularUser;
import com.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public List<AngularUser> getAllUsers() {
        return userRepository
                .findAll()
                .parallelStream()
                .map(AngularUser::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AngularUser getUser(@PathVariable("id") Long id) {
        return new AngularUser(userRepository.findById(id).get());
    }

    @PutMapping()
    public AngularUser updateUser(@RequestBody AngularUser updatedUser) {
        User originalUser = userRepository.findById(updatedUser.getId()).get();
        originalUser.setName(updatedUser.getName());
        return new AngularUser(userRepository.save(originalUser));
    }

    @PostMapping()
    public AngularUser addUser(@RequestBody AngularUser user) {
        return new AngularUser(userRepository.save(user.asUser()));
    }



}

