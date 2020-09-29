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
    public List<AngularUser> getAllUsers() throws InterruptedException {
                Thread.sleep(3000);
        return userRepository
                .findAll()
                .parallelStream()
                .map(AngularUser::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AngularUser getUser(@PathVariable("id") Long id) {
        System.out.println("Got a request for user" + id);
        return new AngularUser(userRepository.findById(id).get());
    }

    @PutMapping()
    public AngularUser updateUser(@RequestBody AngularUser updatedUser) {
        User originalUser = userRepository.findById(updatedUser.getId()).get();
        originalUser.setName(updatedUser.getName());
        return new AngularUser(userRepository.save(originalUser));
    }

    //uses User instead of angularUser because of password
    @PostMapping()
    public AngularUser addUser(@RequestBody User user) {
        return new AngularUser(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/resetPassword/{id}")
    public void resetPassword(@PathVariable("id") Long id) {
        System.out.println("Got a request for user" + id);
        User user = userRepository.findById(id).get();
        user.setPassword("secret");
        userRepository.save(user);
    }



}

